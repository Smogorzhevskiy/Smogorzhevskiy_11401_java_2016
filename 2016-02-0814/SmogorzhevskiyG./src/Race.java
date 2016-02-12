interface Race {
    String race = null;
    String location = null;

    public String capacity(Capacity capacity, String race);

    public void immunity(Capacity capacity, String race);
}