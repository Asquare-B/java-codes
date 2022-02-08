class Thread01 extends Thread{
Thread dependency;
public Thread01(){
dependency = null;
}
public void setDependency(Thread th){
dependency = th;
}
public void run(){
if(dependency != null){
try{
dependency.join();
}catch(InterruptedException e){}
}
System.out.println("Thread "+getName()+" is started....");
for(int i=0; i<10; i++){
System.out.println("Thread "+getName()+" iteration : i = "+i);
}
System.out.println("Thread "+getName()+" completes its execution....");
}
}
class ThreadDemo03{
public static void main(String[] args){
Thread01 th1 = new Thread01();
Thread01 th2 = new Thread01();
Thread01 th3 = new Thread01();
th1.setName("TH01");
th2.setName("TH02");
th3.setName("TH03");
//th1.setDependency(th3);
th3.setDependency(th1);
th1.start();
th2.start();
th3.start();
System.out.println("Main threads ends.......");
}
}