### 기능 목록

• 혜택 안내 전 입력 사항

- [x]  날짜 입력 안내 메세지를 출력한다. `OutputView#printGreetings()`
- [x]  방문 날짜를 입력한다. `InputView#readDate()`
    - [x]  입력이 널값이면 예외 처리한다. `Validator#validateNotNull()`
    - [x]  입력이 숫자가 아니면 예외 처리한다. `Validator#validateInteger()`
    - [x]  입력이 1부터 31까지의 숫자가 아니면 예외 처리한다. `Validator#validateDateRange()`
- [x]  주문 메뉴와 개수를 입력한다. (메뉴-개수) `Validator#validateOrderForm()`
    - [x]  입력이 주어진 형식이 아니면 예외 처리한다. `Validator#validateOrderNotNull()`
    - [x]  입력 메뉴가 메뉴판에 없으면 예외 처리한다. `Validator#validateMenuName()`
    - [x]  메뉴 개수가 숫자가 아니면 예외 처리한다. `Validator#validateOrderForm()`
    - [x]  총 메뉴 개수가 20개가 넘어가면 예외 처리한다. `Validator#validateOrderCount()`
    - [x]  중복된 메뉴가 존재하면 예외 처리한다. `Validator#validateUniqueOrder()`
    - [x]  음료만 주문했는지 확인한다. `Validator#validateNotOnlyDrink()`
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

- [ ]  **Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.**
- [ ]  프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- [ ]  Kotlin 코드 컨벤션 가이드를 준수하며 프로그래밍한다.
- [ ]  프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- [ ]  프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다.
- [ ]  프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- [ ]  indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [ ]  함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- [ ]  JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
- [ ]  else를 지양한다.
- [ ]  도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, [System.in](http://system.in/), Scanner) 로직은 제외한다.
- [ ]  핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
- [ ]  사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- [ ]  `InputView`, `OutputView` 클래스를 참고하여 입출력 클래스를 구현한다.
- [ ]  사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.