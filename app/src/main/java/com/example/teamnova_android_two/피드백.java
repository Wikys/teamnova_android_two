//포커스를 잃었을때 같은 단어 알아보기
//(상호작용할수없을때)

//팝업액티비티와 다이얼로그의 차이

//안드로이드에서 지원해주는거랑 내가만든 커스텀다이얼로그랑 차이점이 뭘까 생각해보기
//(내가만든건 다이얼로그 스타일을준 "액티비티", 얼럿다이얼로그는 액티비티의 일부임)

//답변 : 내가 만든건 다이얼로그처럼 보이는 팝업 액티비티이고 , 다이얼로그는 액티비티가 아님
//대문에 온퍼즈가 실행되지않고 다이얼로그는 액티비티가 아니기때문에
//"액티비티" 생명주기의 영향을 받지않는다

//검사받을때 스킵해도되는지 물어보고 발표?

//생명주기 추가적으로 더 공부
//사용이유같은거 다시생각하게될거임

//온디스트로이에서 저장안하는이유 강제종료시 온디스트로이를 호출되는것을 보장할수없다

//리소스 온퍼즈에서 정리하고
//온퍼즈에서 하는이유 정리하기

//온스타트,온리줌이 아닌 온리스타트에서 타이머 재시작을 구현한이유
//사용자가 홈버튼을 눌렀다가 다시들어왔을때 재시작을 하고싶었고
//이경우엔 온리스타트에 이어 시작되는 온스타트나 온리줌에 구현하지 않은이유는
//제가 현재 불린함수로 타이머 재시작가능여부를 판단하고있는데
//이거를 리줌이나 스타트에 넣게되면 첫 시작시에도 바로 타이머가 작동되어버리기 때문


//생명주기 활용한 액티비티
//메인액티비티(온리줌)
//타이머(온퍼즈,온리스타트)
//무릉헬퍼 (온퍼즈,온리스타트)