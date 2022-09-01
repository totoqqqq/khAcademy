package day002;

class HelloWorld {
	 HelloWorld() {
		System.out.println("Hello World");
		System.out.println(('a'+100)+"Z");//char(a)=int(97);int(97)+int(100)+String(Z);197Z
		System.out.println('a'+(100+"Z"));//(int(100)+string(Z))=string(100Z);char(a)+string(100Z);a100Z
	 }
}