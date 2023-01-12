class DataTypeKey implements IKey {
    private String key;
    public DataTypeKey(String key) {
        this.key = key;
    }

    public void execute() {
        System.out.println("Data type is " + key);
    }
}