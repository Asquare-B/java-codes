class Thread01 extends Thread{
public Thread callingThread;
public Thread01(Thread th){
callingThread = th;
}
public void run(){
System.out.println("Inside thread : " + getName());
if(getName().equals("TH01")){
suspend();
}
for(int i=0; i<5;i++){
if(i==2){
yield();
}
System.out.println("Main Thread status: +"+
callingThread.getState());
System.out.println(getName()+" says: "+i);
}
System.out.println(getName()+" completes its execution ");
}
}
public class trial{
public static void main(String[] args){
Thread01 th1 = new Thread01(Thread.currentThread());
Thread01 th2 = new Thread01(Thread.currentThread());
Thread01 th3 = new Thread01(Thread.currentThread());
th1.setName("TH01");
th2.setName("TH02");
th3.setName("TH03");
th1.start();
th2.start();
th3.start();
while(true){
if(!th2.isAlive()){
th1.resume();
break;
}
}
}
}