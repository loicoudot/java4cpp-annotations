java4cpp-annotations
====================

Annotations classes for java4cpp project. 

Gets full informations directly on the [java4cpp-core](https://github.com/loicoudot/java4cpp-core/wiki) page project.

Use the java4cpp annotations for controlling the mappings between the java classes and C++ proxies directly in the source code. It is also possible to define the mappings with some externals XML mappings file.

Overview
--------

Consider this annotated java class :
```java
	package my.package;

	@Java4Cpp
	class MyJavaClass {
		public static String myStaticField;
		@Java4CppNoWrappe
		public static String unexportedField;
		
		public MyJavaClass() {
		}
		
		@Java4CppNoWrappe
		public MyJavaClass(double arg) {
		}
		
		@Java4CppWrappe("cppMethod")
		public void myMethod(boolean arg) {
		}
	}
```	
java4cpp will generate the following C++ proxy (of course the final result may vary according to the XML templates configuration)
```cpp
	namespace my {
		namespace package {

			class MyJavaClass
			{
				public:
					static java::lang::String getMyStaticField();
					
					MyJavaClass();
					virtual ~MyJavaClass();
					
					void cppMethod(bool arg1);
			};
		}
	}
```
