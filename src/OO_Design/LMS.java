public class Book{
	private String tAuth,tTitle,pCnt,year,edt;
	public Book(string auth,string tit){
		tAuth=auth;
		tTitle=tit;
		pCnt=pages;
		year=yPublished;
		edt=yEdt;
	}
	public String getAuthor(){
		return tAuth;
	}
	public String getTitle(){
		return tTitle;
	}
	public String getPageCnt(){
		return pCnt;
	}
	public String getYear()	{
		return year;
	}
	public String getEdt()	{
		return edt;
	}
};
public interface LibItem{
	public String getID;
	//return true if checkout(no holder) 
	//and assign new holder
	//otherwise return false
	public boolean CheckOut(String holder);
	public String getHolder();
}
public class LibBook 
extends Book implements LibItem {
	private String theID;
	private String theHolder;
	public LibBook(String author,
	String title,String id,int pgCnt,int year,int ed){
		super(author,title,pageCount,year,edition);
		theId=id;
	}
	public String getHolder(){
		return theHolder;
	}
	public boolean checkOut(String hld){
		if(theHolder==null){
			theHolder=hld;
			return true;
		}
		return false;
	}
	public String getID(){
		return theID;
	}
};

public class Library {
	private Map items;
	public  Library(){
		items=new HashMap();
	}
	public void add(LibItem thIt){
		items.put(thIt.getID(),thIt);
	}
	public void checkOut(String id,String holder){
		LibItem it=(LibItem)items.get(id);
		it.checkOut(holder);
	}
	public  String getHolder(String id){
		LibItem  it=(LibItem)items.get(id);
		return item.getHolder();
	}
};