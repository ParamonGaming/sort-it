class DataTypeKey implements Key {
    private Class<?> dataType;
    public DataTypeKey(Class<?> data) {
        dataType=data;
    }
    public Class<?> getDataType()
    {
        return dataType;
    }
    public void execute() {
        System.out.println("Data type is " + dataType.getTypeName());
    }
}