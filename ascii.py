print("보물섬에 오신것을 환영합니다!")
print("보물섬에서 보물을 찾아보세요~")

choice1 = input("당신은 갈림길에 있습니다. 오른쪽(r), 왼쪽(l)을 선택하세요: ").lower

if choice1 == "l":
    choice1 = input("호수를 만났습니다. 기다릴 것인지(w) 또는 수영을 할것인지(s) 선택하세요. :").lower()
    if choice2 == "w":
        choice3 = input("당신은 3개의 문앞에 도착했습니다. 빨간색(r),노란색(y),파란색(b) 어떤 색을 선택할까요? :").lower
        if choice3 == "r":
            print("불구덩이에 빠졌습니다. Game Over")
        elif choice3 == "y":
            print("보석을 발견했습니다!, You win! 이름을 입력하세요!")
            name = input("name: ")
            print("게임의 우승자는 "+ name + "입니다!")
        elif choice3 =="b":
            print("바다에 빠졌습니다. Game Over")
        else :
            print("Game Over")
    else:
        print("Game Over")
else:
    print("Game Over")     
    