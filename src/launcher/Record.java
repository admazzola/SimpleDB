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
	
	public Record(String line) {
		String[] array = line.split(",");
		
		this.name=array[0];
		this.key=array[1];
		this.data=array[2];
		this.timestamp=array[3];
	}

	@Override
	public String toString(){
		return name + " : " + key;
	}

	public String getData() {
		
		return name +"," + key+"," + data+"," + timestamp;
	}
	
	
}



