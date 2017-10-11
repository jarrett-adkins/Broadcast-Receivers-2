package com.example.admin.broadcasthomework;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Admin on 10/10/2017.
 */

public class Person implements Parcelable {

    String firstName, lastName;
    int age, weight;

    public Person(String firstName, String lastName, int age, int weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.weight = weight;
    }

    protected Person(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        age = in.readInt();
        weight = in.readInt();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public int getWeight() {
        return weight;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString( firstName );
        parcel.writeString( lastName );
        parcel.writeInt( age );
        parcel.writeInt( weight );
    }
}
