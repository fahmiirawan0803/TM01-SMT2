package Model;

public class ResponseModel {

    private String icode;
    private String gcode;
    private String barcode;
    private String name;
    private String quantity;
    private String unit;

    public String getIcode() {
        return icode;
    }

    public void setIcode(String icode) {
        this.icode = icode;
    }

    public String getGcode() {
        return gcode;
    }

    public void setGcode(String gcode) {
        this.gcode = gcode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBrands() {
        return brands;
    }

    public void setBrands(String brands) {
        this.brands = brands;
    }

    public String getCogs() {
        return cogs;
    }

    public void setCogs(String cogs) {
        this.cogs = cogs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String size;
    private String brands;
    private String cogs;

    public int getSell() {
        return sell;
    }

    public void setSell(int sell) {
        this.sell = sell;
    }

    private int sell;
    private String status;
    private String id;

/*    public ResponseModel(String icode, String gcode, String barcode, String name,
                         String quantity, String unit, String size, String brands,
                         String cogs, String sell, String status, String id) {
        this.icode = icode;
        this.gcode = gcode;
        this.barcode = barcode;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.size = size;
        this.brands = brands;
        this.cogs = cogs;
        this.sell = sell;
        this.status = status;
        this.id = id;
    }*/

}
