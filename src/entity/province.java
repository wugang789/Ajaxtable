package entity;

import java.util.Set;
/**
 * 省类
 * @author Administrator
 *
 */
public class province {
	/**
	 * id
	 */
	private int id;
	/**
	 * 用户名
	 */
	private String provinceName;
	/**
	 * 集合类
	 */
	private Set<?> myCity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Set<?> getMyCity() {
		return myCity;
	}

	public void setMyCity(Set<?> myCity) {
		this.myCity = myCity;
	}

	@Override
	public String toString() {
		return "province [id=" + id + ", provinceName=" + provinceName
				+ ", myCity=" + myCity + "]";
	}

	public province(int id, String provinceName, Set<?> myCity) {
		super();
		this.id = id;
		this.provinceName = provinceName;
		this.myCity = myCity;
	}

	public province() {
		super();
	}

}
