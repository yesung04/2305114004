import sys

print("파이썬 피자에 오신것을 환영합니다!")
order = input("피자를 주문하시겠습니까? (Y/N):")
if order == "N":
    print("주문이 취소되었습니다.")
    sys.exit()
size = input("피자 사이즈를 선택하세요 (S, M, L): ")
pepperoni = input("페퍼로니를 추가하시겠습니까? (Y/N): ")
cheese = input("치즈를 추가하시겠습니까? (Y/N): ")

price = 0

if size == "S":
    price += 15000
elif size == "M":
    price += 20000
elif size == "L":
    price += 30000

if pepperoni == "Y":
    price += 2000

if cheese == "Y":
    price += 3000

print(f"총 지불하실 금액은 {price}원입니다.")
