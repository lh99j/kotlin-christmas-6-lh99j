### 기능 목록

• 혜택 안내 전 입력 사항

- [x]  날짜 입력 안내 메세지를 출력한다. `OutputView#printGreetings()`
- [x]  방문 날짜를 입력한다. `InputView#readDate()`
    - [x]  입력이 널값이면 예외 처리한다. `DateValidator#validateDateNotNull()`
    - [x]  입력이 숫자가 아니면 예외 처리한다. `DateValidator#validateDateInteger()`
    - [x]  입력이 1부터 31까지의 숫자가 아니면 예외 처리한다. `DateValidator#validateDateRange()`
- [x]  주문 메뉴와 개수를 입력한다. (메뉴-개수) `OrderValidator#validateOrderForm()`
    - [x]  입력이 주어진 형식이 아니면 예외 처리한다. `OrderValidator#validateOrderNotNull()`
    - [x]  입력 메뉴가 메뉴판에 없으면 예외 처리한다. `OrderValidator#validateMenuName()`
    - [x]  메뉴 개수가 숫자가 아니면 예외 처리한다. `OrderValidator#validateOrderForm()`
    - [x]  총 메뉴 개수가 20개가 넘어가면 예외 처리한다. `OrderValidator#validateOrderCount()`
    - [x]  중복된 메뉴가 존재하면 예외 처리한다. `OrderValidator#validateUniqueOrder()`
    - [x]  음료만 주문했는지 확인한다. `OrderValidator#validateNotOnlyDrink()`
- [x]  주문 메뉴를 출력한다. `OutputView#printMenu()`

• 할인 전 총 주문 금액

- [x]  할인 전 총 주문 금액을 계산한다. `Order#getTotalPrice()`
- [x]  할인 전 총 주문 금액을 출력한다. `OutputView#printTotalPrice()`

• 이벤트 대상인지 확인

- [x]  이벤트 대상인지 확인한다. `Discount#checkTarget()`
    - [x]  총 주문 금액이 1만원 이상인지 확인한다. `MainController#applyBenefits()`
    - [x]  이벤트 대상이면 이벤트 혜택을 계산한다. `Discount#getPrice()`

• 증정 메뉴 지급 여부 확인

- [x]  증정 메뉴를 받을 수 있는지 확인한다. `GiftDiscount#checkTarget()`
    - [x]  증정 메뉴는 총 주문 금액이 12만원 이상이면 지급한다. `GiftDiscount#getPrice()`
- [x]  증정 메뉴를 출력한다. `OutputView#printGift()`
    - [x]  없으면 ‘없음’을 출력한다.

• 할인 혜택을 계산한다. [🌟핵심 기능 🌟]

- [x]  디데이 할인을 계산한다. `DDayDiscount#getPrice()`
    - [x]  입력 날짜가 25일 전이면 1일이 1000원 기준으로 매일 100원씩 증가한다.
    - [x]  25일 이후면 디데이 할인을 계산하지 않는다.
- [x]  입력된 날짜가 평일인지 주말인지 확인한다. `Calendar#checkWeekday()/checkWeekend()`
    - [x]  평일이면 디저트 메뉴를 개당 2,023원 할인한다. `WeekdayDiscount#getPrice()`
    - [x]  주말이면 메인 메뉴를 개당 2,023원 할인한다. `WeekendDiscount#getPrice()`
- [x]  달력에 별 표시가 있는지 확인한다. `Calendar#checkSpecialDay()`
    - [x]  달력에 별 표시가 있다면 1000원 할인한다. `SpecialDiscount#getPrice()`
- [x]  증정 이벤트를 확인한다. `GiftDiscount#checkTarget()`
    - [x]  증정 이벤트를 받았다면 25,000원 할인혜택을 적용한다. `GiftDiscount#getPrice()`
- [x]  받은 혜택을 출력한다. `OutputView#printBenefits()`
    - [x]  없으면 ‘없음’을 출력한다.
- [x]  총 혜택 금액을 계산한다. `Benefits#getTotalBenefit()`
    - [x]  총혜택 금액 = 할인 금액의 합계 + 증정 메뉴의 가격이다.
- [x]  총 혜택 금액을 출력한다. `OutputView#printTotalBenefits()`
- [x]  할인 후 예상 결제 금액을 계산한다. `MainController#getPriceAfterDiscount()`
- [x]  할인 후 예상 결제 금액을 출력한다. `OutputView#printPriceAfterDiscount()`
- [x]  이벤트 배지 대상인지 계산한다. `Badge#getType()`
    - [x]  총 혜택 금액이 5천원 이상이면 별을 부여한다.
    - [x]  총 혜택 금액이 1만원 이상이면 트리를 부여한다.
    - [x]  총 혜택 금액이 2만원 이상이면 산타를 부여한다.
- [x]  부여받은 배지를 출력한다. `OutputView#printBadgeType()`

### 기능 요구 사항

- [x]  **Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.**
- [x]  프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- [x]  Kotlin 코드 컨벤션 가이드를 준수하며 프로그래밍한다.
- [x]  프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다.
- [x]  프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- [x]  indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [x]  함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- [x]  JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
- [x]  else를 지양한다.
- [x]  도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, [System.in](http://system.in/), Scanner) 로직은 제외한다.
- [x]  핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
- [x]  사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- [x]  `InputView`, `OutputView` 클래스를 참고하여 입출력 클래스를 구현한다.
- [x]  사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

<br>

### 프로젝트 구조

```
.
├── Application.kt
├── controller
│   └── MainController.kt
├── model
│   ├── Badge.kt
│   ├── Benefits.kt
│   ├── Calendar.kt
│   ├── MenuBoard.kt
│   ├── Order.kt
│   ├── data
│   │   ├── Menu.kt
│   │   └── OrderForm.kt
│   └── discount
│       ├── DDayDiscount.kt
│       ├── Discount.kt
│       ├── GiftDiscount.kt
│       ├── SpecialDiscount.kt
│       ├── WeekdayDiscount.kt
│       └── WeekendDiscount.kt
├── util
│   ├── Constants.kt
│   ├── OrderGenerator.kt
│   └── validator
│       ├── DateValidator.kt
│       └── OrderValidator.kt
└── view
    ├── InputView.kt
    └── OutputView.kt
```

### Appliction.kt

`PromotionController` 를 호출하여 이벤트 플래너를 보여준다.

### Controller

- `PromotionController` : 이벤트 플래너 관련 메인 로직을 수행한다.

### Model

- `data/Menu` : (메뉴 이름, 메뉴 가격)의 정보를 가지고 있는 `data class`이다.
- `data/OrderForm` : (Menu, 주문 개수)의 정보를 가지고 있는 `data class` 이다.
- `Discount` : 할인과 관련된 메서드를 가지고 있는 `Interface` 이다.
   - `checkTarget : Boolean` : 할인 대상인지 확인하는 메서드이다.
   - `getPrice : Int` : 할인 가격을 가져오는 메서드이다.
      - `DDayDiscount` :  디데이 할인을 관리한다.
      - `WeekdayDiscount` : 평일 할인을 관리한다.
      - `WeekendDiscount` : 주말 할인을 관리한다.
      - `SpeicalDiscount` : 특별 할인을 관리한다.
      - `GiftDiscount` : 증정 할인을 관리한다.
- `MenuBoard` : 메뉴판을 관리하는 모델이다.
   - `validateMenu(name: String)` : `name`이 메뉴판에 있는지 확인하여 없으면 예외를 발생시킨다.
   - `getMenuPrice(name: String): Int` : `name`의 메뉴 가격을 가져온다.
   - `getFoodCategory(name: String): Int` : `name` 메뉴의 카테고리에 해당하는 인덱스를 가져온다.
- `Order` : 주문 목록을 관리하는 모델이다.
   - `getTotalPrice(): Int` : 총 주문 음식의 가격을 가져온다.
   - `getMenu()` : 주문 목록을 가져온다.
- `Calendar` : 달력(평일, 주말, 특별 날짜)를 관리하는 모델이다.
   - `checkWeekend(day: Int): Boolean` : `day`가 주말인지 확인한다.
   - `checkWeekday(day: Int): Boolean` : `day` 가 평일인지 확인한다.
   - `checkSpecialDay(day: Int): Boolean` : `day` 가 특별 날짜인지 확인한다.
- `Benefits` : 할인 혜택 목록을 관리하는 모델이다.
   - `addHistory(type: String, price: Int)` : 할인 목록에 type과 price를 저장한다.
   - `getTotalBenefits(): Int` : 총 할인 혜택을 가져온다.
   - `getTotalDiscount(): Int` : 총 할인 금액을 가져온다. (증정 할인을 뺀 총 할인 혜택 금액)
- `Badge` : 배지 목록을 관리하는 `enum class` 이다.
   - `getType(price: Int): String` : price에 맞는 배지 타입을 가져온다.

### Util

- `DateValidator` : 날짜 관련된 검증 로직을 관리한다.
- `OrderValidator` : 주문 관련된 검증 로직을 관리한다.
- `Constants` : 여러 곳에서 쓰이는 불변값들을 관리한다.
- `OrderGenerator` : Order 클래스에 맞는 형식으로 변환하는 작업을 담당한다.
   - `makeOrder(input: List<String>): Order` : 주어진 input을 Order로 반환한다.

     → listOf(”제로콜라-1”, “티본스테이크-3”)의 형식을
     list[Category] { OrderForm(Menu(”제로콜라”, 3000, 1)) …  } 으로 변환한다.


### View

- `InputView` : 입력과 관련된 로직을 담당한다.
- `Outputview` : 출력과 관련된 로직을 담당한다.