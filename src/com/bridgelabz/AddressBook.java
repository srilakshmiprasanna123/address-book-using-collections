package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {
    static Scanner sc = new Scanner(System.in);
    static List<Person> adressBook = new ArrayList<Person>();
    static Person addressBoook=new Person();

    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book Problem");
        AddressBook addressBookList=new AddressBook();
        boolean condition = true;

        while (condition == true) {
            System.out.println("Enter a options"+"\n"+"1.Do you want to continue in existing addressbook"+"\n"+"2.Create a new address book");
            int options = sc.nextInt();
            switch(options) {
                case 1:
                    boolean condition1 = true;
                    while (condition1== true) {
                        System.out.println("1.add" +"\n" +"2.display"+ "\n" + "3.edit"+"\n" +"4.delete"+"\n"+"5.RemoveDuplicates"+"\n"+"6.SearchPerson in a city or State"+"\n"+"7.exit");
                        int option = sc.nextInt();
                        switch (option) {
                            case 1:
                                addressBookList.addContactDetails();
                                break;
                            case 2:
                                addressBookList.display();
                                break;
                            case 3:
                                addressBookList.editContactDetails();
                                break;
                            case 4:
                                addressBookList.deleteContact();
                                break;
                            case 5:
                                System.out.println("enter a  name");
                                String personName=sc.next();
                                addressBookList.removeDuplicates(personName);
                            case 6:
                                System.out.println("Enter a city and state:-");
                                String city=sc.next();
                                String state=sc.next();
                                addressBookList.searchPersonInCityOrState(city, state);
                                break;
                            case 7:
                                condition1 = false;
                                break;
                            default:
                                System.out.println("Invalid Input");
                        }
                    }
                    break;
                case 2:
                    HashMap<String, List<Person>> map = new HashMap<>();
                    List<Person> arrayList = new ArrayList<>();
                    Person addessBook1=addressBoook;
                    arrayList.add(addessBook1);
                    map.put("Ram", arrayList);
                    System.out.println(map);
                    if (map.containsKey("Ram")) {
                        List<Person> ram = map.get("Ram");
                        Person addessBook2=addressBoook;
                        ram.add(addessBook2);
                        map.put("Ram", ram);
                    }
                    System.out.println(map);
                    Person addessBook3=addressBoook;
                    arrayList.add(addessBook3);
                    map.put("Abhi", arrayList);
                    System.out.println(map);
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    public void searchPersonInCityOrState(String city, String state) {
        List<Person> seachPerson=adressBook.stream().filter(person->person.getCity().equals(city)).filter(person->person.getState().equals(state)).collect(Collectors.toList());
        System.out.println("After searching person in a city or state is:"+seachPerson);
    }

    public void removeDuplicates(String personName) {
        List<Person> AfterRemoveDuplicates=adressBook.stream().filter(person->person.getFirstName().equalsIgnoreCase(personName)).distinct().collect(Collectors.toList());
        System.out.println("After a removing duplicate elements"+AfterRemoveDuplicates);
    }

    public void addContactDetails() {
        Person details=new Person();
        System.out.println("Enter a first name:");
        details.setFirstName(sc.next());
        System.out.println("Enter a last name:");
        details.setLastName(sc.next());
        System.out.println("Enter a Address:");
        details.setAddress(sc.next());
        System.out.println("Enter a City name:");
        details.setCity(sc.next());
        System.out.println("Enter a state:");
        details.setState(sc.next());
        System.out.println("Enter a email:");
        details.setEmail(sc.next());
        System.out.println("Enter a zip code:");
        details.setZip(sc.nextInt());
        System.out.println("Enter a phone number:");
        details.setPhoneNumber(sc.nextLong());

        adressBook.add(details);
        System.out.print(adressBook);
        System.out.println("succesfully added person new contacts");
    }

    public void editContactDetails() {
        System.out.println("enter a name for edit:");
        String editName=sc.next();
        for(int i=0; i<adressBook.size(); i++) {
            if(adressBook.get(i).getFirstName().equals(editName)) {
                System.out.println("select options");
                System.out.println("\n1.First Name\n2.Last Name\n3.Address\n4.City\n5.State\n6.Zip\n7.Phone Number\n8.Email");
                int editOption=sc.nextInt();

                switch(editOption) {
                    case 1:
                        System.out.println("Enter a First name:");
                        String editFirstName=sc.next();
                        adressBook.get(i).setFirstName(editFirstName);
                        System.out.println(editFirstName);
                        break;
                    case 2:
                        System.out.print("Enter a Last name:");
                        adressBook.get(i).setLastName(sc.next());
                        break;
                    case 3:
                        System.out.print("Enter a Address:");
                        adressBook.get(i).setAddress(sc.next());
                        break;
                    case 4:
                        System.out.print("Enter a city:");
                        adressBook.get(i).setCity(sc.nextLine());
                        break;
                    case 5:
                        System.out.print("Enter a state:");
                        adressBook.get(i).setState(sc.nextLine());
                        break;
                    case 6:
                        System.out.print("Enter a zip code:");
                        adressBook.get(i).setZip(sc.nextInt());
                        break;
                    case 7:
                        System.out.print("Enter a phone number:");
                        adressBook.get(i).setPhoneNumber(sc.nextLong());
                        break;
                    case 8:
                        System.out.print("Enter a email:");
                        adressBook.get(i).setEmail(sc.nextLine());
                        break;
                    default:
                        System.out.println("enter valid contact");
                }
            }
            System.out.println("Edited list is:");
            System.out.println(adressBook);
        }
    }

    public void deleteContact() {
        System.out.println("confirm the name to delete contact");
        String confirmName=sc.next();
        for (int i = 0; i < adressBook.size(); i++) {
            if(adressBook.get(i).getFirstName().equalsIgnoreCase(confirmName));
            Person person = adressBook.get(i);
            adressBook.remove(person);
        }
        System.out.println(adressBook);
    }

    public void display() {
        for(int i=0; i<adressBook.size();i++) {
            Person person=adressBook.get(i);
            System.out.println("FirstName"+":="+person.getFirstName()+"\n"+"lastname"+":= "+person.getLastName()+"\n"+"Address"+":= "+person.getAddress()
                    +"\n"+"City"+":= "+person.getCity()+"\n"+"State"+":="+person.getState()+"\n"+"Zip"+":= "+person.getZip()+"\n"+"PhoneNumber"+":= "+person.getPhoneNumber()+"\n"+"Email"+":= "+person.getEmail());
        }
    }
}