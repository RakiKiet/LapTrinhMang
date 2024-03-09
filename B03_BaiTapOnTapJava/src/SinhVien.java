public class SinhVien {
    private String maSinhVien;
    private String hoVaTen;
    private double diemTB;

    public SinhVien(String maSinhVien, String hoVaTen, double diemTB) {
        this.maSinhVien = maSinhVien;
        this.hoVaTen = hoVaTen;
        this.diemTB = diemTB;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }
}
