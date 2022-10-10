package services;


public interface UserServices {
    public Boolean validateAccess(String code);
    public void mainMenu();
    public void readData();
    public void writeData();
}
