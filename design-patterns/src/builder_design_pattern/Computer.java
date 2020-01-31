package builder_design_pattern;

public class Computer {
	
	private String HHD;
	private String RAM;
	
	private boolean isGraphicsCardEnabled;
	private boolean isBluetoothEnabled;
	
	
	public String getHHD() {
		return HHD;
	}
	public String getRAM() {
		return RAM;
	}
	public boolean isGraphicsCardEnabled() {
		return isGraphicsCardEnabled;
	}
	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}
	
	private Computer(ComputerBuilder builder) {
		this.HHD=builder.HDD;
		this.RAM=builder.RAM;
		this.isGraphicsCardEnabled=builder.isGraphicsCardEnabled;
		this.isBluetoothEnabled=builder.isBluetoothEnabled;
	}
	
	
	
	public static class ComputerBuilder{
		
		private String HDD;
		private String RAM;
		
		private boolean isGraphicsCardEnabled;
		private boolean isBluetoothEnabled;
		
		public ComputerBuilder(String hdd, String ram) {
			this.HDD=hdd;
			this.RAM=ram;
			
		}

	
		public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
			this.isGraphicsCardEnabled = isGraphicsCardEnabled;
			return this;
		}


		public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
			return this;
		}


		public Computer build() {
			return new Computer(this);
		}
		
		
	}
	

}
