my_choice = int(input("무엇을 내겠습니까? 바위(0), 보(1), 가위(2)"))
if my_choice >= 3 or my_choice <0:
    print("잘못된 숫자를 입력했습니다")

else:
    print(f"나의 선택은 : ")
    print(img_hands[my_choice])

    computer_choice = random.randint(0, 2)
    print(f"컴퓨터의 선택은: ")
    print(img_hands[computer_choice])

    if computer_choice == 0 and my_choice ==2:
        print("컴퓨터가 이겼다")
    elif my_choice == 0 and computer_choice == 2:
        print("내가 이겼다!")
    elif computer_choice > my_choice:
        print("컴퓨터가 이겼다")
    elif my_choice == computer_choice:
        print("비겼다!")
    elif my_choice > computer_choice:
        print("내가 이겼다!") 