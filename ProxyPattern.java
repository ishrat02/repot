interface EBook{
    void display();
    //edit from feature
}
class RealEBook implements EBook{
    String filename;
    public RealEBook(String filename){
        this.filename=filename;
        loadFromDisk(filename);
    }
    @Override
    public void display()
    {
        System.out.println("Displaying "+filename);
    }
    public void loadFromDisk(String filename)
    {
        System.out.println("Loading "+filename);
    }
}
class ProxyEBook implements EBook{
    RealEBook realEBook;
    String filename;
    public ProxyEBook(String filename)
    {
        this.filename=filename;
    }
    @Override
    public void display()
    {
        if(realEBook==null)
        {
            realEBook=new RealEBook(filename);
        }
        realEBook.display();
    }
}
public class ProxyPattern{
    public static void main(String[] args) {
        EBook proxyImage=new ProxyEBook("newfile");
        proxyImage.display();
        System.out.println("");
        proxyImage.display();
        EBook newproxy=new ProxyEBook("anotherfile");
        newproxy.display();
        System.out.println("");
        newproxy.display();
    }
}