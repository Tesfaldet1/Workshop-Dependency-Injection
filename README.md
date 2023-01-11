# Workshop-Dependency-Injection
Workshop
Inversion of Control and Dependency  injection  in Spring.  Your workshopis to build a console-based student management system in Spring framework by making the Spring Containerbuild the StudentManagementbean for you. We could do this in a lot of different ways with XML, Java code or annotations. We are going to use a combination of annotations and Java configured beans. 
Part 1.Create a package called data_access.
2.Create the interface StudentDaoinside data_access. 
3.Create the class StudentDaoListImplinside data_access. 
4.Make StudentDaoListImplimplement StudentDao. 
5.Create a new package called models. 
6.Create the Studentclass inside the models-package 
7.Annotate StudentDaoListImplclass with @Component
8.Configure component scanning by doing the following: 
-Create a new configuration class. (“ComponentScanConfig”would be a good name).
-Annotate your configuration class with @Configuration
-Add @ComponentScan(“packagename”) to the configuration class
9.In your main method write this:AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigFileName.class);StudentDao studentDao = context.getBean(StudentDao.class);
If youcompile the code without Exceptions goahead and make a commit to a Repository
