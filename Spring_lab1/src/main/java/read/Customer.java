package read;


public class Customer {
    private int id, buy, skid;
    private String surname, name, otch, phone;
    private long card;
    public Customer(int id, String surname, String name, String otch, String phone, long card, int buy, int skid) {
        this.id = id;
        this.buy = buy;
        this.skid = skid;
        this.surname = surname;
        this.name = name;
        this.otch = otch;
        this.phone = phone;
        this.card = card;
    }
    public Customer() {
        this.id = 0;
        this.buy = 0;
        this.skid = 0;
        this.surname = null;
        this.name = null;
        this.otch = null;
        this.phone = null;
        this.card = 0;
    }
    public int getId(){
        return this.id;
    }
    public int getBuy(){
        return this.buy;
    }
    public int getSkid(){
        return this.skid;
    }
    public String getSurname(){
        return this.surname;
    }
    public String getName(){
        return this.name;
    }
    public String getOtch(){
        return this.otch;
    }
    public String getPhone(){
        return this.phone;
    }
    public long getCard(){
        return this.card;
    }
    public void setId(int value){
        this.id=value;
    }
    public void setBuy(int value){
        this.buy=value;
    }
    public void setSkid(int value){
        this.skid=value;
    }
    public void setName(String value){
        this.name=value;
    }
    public void setSurame(String value){
        this.surname=value;
    }
    public void setOtch(String value){
        this.otch=value;
    }
    public void setPhone(String value){
        this.phone=value;
    }
    public void setCard(long value){
        this.card=value;
    }
    public static String getLine(){
        String string;
        return string="+---+------------+-----------+----------------+--------------+------------------+----+----+";
    }
    @Override
    public String toString(){
        return String.format("|%-3d|%-12s|%-11s|%-16s|%-14s|%-18d|%-4d|%-4d|",this.id,this.surname,this.name,this.otch,this.phone,this.card,this.buy,this.skid);
    }
    @Override
    public boolean equals(Object a){
        if (this==a) return true;
        if (a==null) return false;
        if (this.getClass() != a.getClass()) return false;
        Customer other = (Customer) a;
        if (this.name != other.name) return false;
        if (this.surname != other.surname) return false;
        if (this.otch != other.otch) return false;
        return true;
    }
}