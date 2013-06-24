package entity;

/**
 * 城市类
 * 
 * @author Administrator
 * 
 */
public class city {
	/**
	 * id
	 */
	private int id;
	/**
	 * 城市名
	 */
	private String cityName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "city [id=" + id + ", cityName=" + cityName + "]";
	}

	public city() {
		super();
	}

	public city(int id, String cityName) {
		super();
		this.id = id;
		this.cityName = cityName;
	}

}
