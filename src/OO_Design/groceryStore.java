public class GroceryStore{
	//instance variables
	Cashier myCsh;
	public int KINDS_OF_ITEMS=4;
	public GroceryItem[] it=
		new GroceryItem(KINDS_OF_ITEMS);
	public int[] itemCnt=new int[KINDS_OF_ITEMS];
	double money=1000.0;
	GroceryStore(){
		it[0]=new GroceryItem("milk",2.12);
		it[1]=new GroceryItem("butter",2.50);
		it[2]=new GroceryItem("eggs",6);
		for(int i=0;i<KINDS_OF_ITEMS;i++)
			itemCnt[i]=50;
	}
	public void hire(Cashier csh){
		myCsh=csh;
		csh.takePosition(this);//this=store
	}
	public class Customer{
		GroceryItem[] mySB=new GroceryItem[20];
		Random rd=new Random();
		double myM=100.00;
		public void shop(GroceryStore gs){
			selectGroceries(gs);
			checkOut(gs);
		}
		public void selectGroceries(GroceryStore st){
			int itemsInBask=0;
			for(int i=0;i<st.KINDS_OF_ITEMS;i++){
				for(int j=0;j<3;j++){//choose upto 3 items
					mySB[itemsInBask]=store.itemCnt[i]-1;
					itemsInBask++;
				}
			}
		}
		void checkOut(GroceryStore gs){
			Cashier cs=gs.getCashier();
			double t=Cashier.getBill(mySB);
			myM-=t;
			Cashier.pay(t);
		}
	};
	public class Cashier{
		GroceryStore ms;
		public void  takePos(GroceryStore gs){
			ms=gs;
		}
		public double getBill(GroceryItem[] item){
			double tot=0;
			int itemNum=0;
			while(item[itemNum]!=null){
				tot+=item[itemNum].price;
				System.out.println(item[itemNum].name + " " + item[itemNum].price);
				itemNum+=1;
			}
			Systme.out.println("TOTAL " +tot);
			return tot;
		}
		public void pay(double amt){
			ms.money+=amt;
		}
	};
	public class GroceryItem{
		//instance vars
		public String name;
		public String price;
		//ctor
		GroceryItem(String name,double price){
			this.name=name;
			this.price=price;
		}
	}
	public static void main(String args[]){
		GroceryStore gs=new GroceryStore();
		Cashier c=new Cashier(gs);
		gs.hire(c);
		Customer cs=new Customer(gs);
		customer.shop();
	}
};