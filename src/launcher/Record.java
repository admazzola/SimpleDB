package launcher;

public class Record {
	
	
	
	String name;
	String key;
	String data;
	String timestamp;
	
	public Record(String name, String key, String data, String timestamp){
		this.name=name;
		this.key=key;
		this.data=data;
		this.timestamp=timestamp;
		
		
	}
	
	@Override
	public String toString(){
		return name + " : " + key;
	}

	public String getData() {
		
		return name +"," + key+"," + data+"," + timestamp;
	}
	
	
}



