package Entity;

import java.util.Objects;

public class LoaiDichVu {
	private String maLoaiDichVu;
	private String tenLoaiDichVu;
	public LoaiDichVu(String maLoaiDichVu, String tenLoaiDichVu) {
		super();
		this.maLoaiDichVu = maLoaiDichVu;
		this.tenLoaiDichVu = tenLoaiDichVu;
	}
	
	
	public LoaiDichVu(String maLoaiDichVu) {
		super();
		this.maLoaiDichVu = maLoaiDichVu;
	}


	@Override
	public int hashCode() {
		return Objects.hash(maLoaiDichVu);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiDichVu other = (LoaiDichVu) obj;
		return Objects.equals(maLoaiDichVu, other.maLoaiDichVu);
	}


	public String getMaLoaiDichVu() {
		return maLoaiDichVu;
	}

	public void setMaLoaiDichVu(String maLoaiDichVu) {
		this.maLoaiDichVu = maLoaiDichVu;
	}

	public String getTenLoaiDichVu() {
		return tenLoaiDichVu;
	}

	public void setTenLoaiDichVu(String tenLoaiDichVu) {
		this.tenLoaiDichVu = tenLoaiDichVu;
	}
	public String toString() {
		return String.format("%s-%s",maLoaiDichVu,tenLoaiDichVu);
	}
	
}
