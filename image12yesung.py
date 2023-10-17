import cv2


face_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')


cap = cv2.VideoCapture(0)

while True:
    ret, frame = cap.read()
    

    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    

    faces = face_cascade.detectMultiScale(gray, scaleFactor=1.1, minNeighbors=5, minSize=(30, 30))
    
    for (x, y, w, h) in faces:
      
        face = frame[y:y+h, x:x+w]
        face = cv2.GaussianBlur(face, (99, 99), 30)  
        
        
        frame[y:y+h, x:x+w] = face
    
 
    cv2.imshow('Face Mosaic', frame)
    
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

cap.release()
cv2.destroyAllWindows()