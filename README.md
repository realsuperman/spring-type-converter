## Spring type converter
요청 파라미터를 다른 형식으로 변경하고 싶을 때 스프링 타입 컨버터를 사용하게 된다 가령 문자열 "123"이 날라왔을 때 이걸 숫자 123으로 처리하고 싶은경우이다.

##
스프링에서는 Converter라는 인터페이스를 제공해준다 제네릭 클래스이며 S는 바꿀 객체 T는 바꿔질 객체이다 String to interger로 바꾸고 싶으면 
<String,Integer> 이런식으로 작성하면 된다 해당 인터페이스를 구현한 클래스를 생성 후 스프링 부트에 등록하면 스프링 부트가 해당 컨버터 클래스를 빈으로 잘 등록해준다

##
타임리프에서는 ${{}} 이런식으로 중괄호를 한번 더 작성하면 자동으로 컨버터가 실행된다(참고로 th-field 경우 기본적으로 컨버터가 동작한다)

##
스프링에서는 Formatter라는 인터페이스도 제공해준다 해당 인터페이스는 Converter와 유사하다 포멧터의 경우 "1,000" -> 1000 이렇게 변경하고자 할 때 사용한다
등록은 컨버터 등록처럼 하면 된다

##
스프링에서는 애노테이션 기반 포멧터를 등록할 수 있다 간단한 사용방법은 아래와 같다

    @NumberFormat(pattern = "###,###")
    private Integer number;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime localDateTime;
