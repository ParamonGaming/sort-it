class DataTypeKeyFactory implements IKeyFactory {
    public IKey create(String key) {
        return new DataTypeKey(key);
    }
}
