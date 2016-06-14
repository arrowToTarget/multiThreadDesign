package com.lewis.protoBuf;

import com.example.tutorial.AddressBookProtos;
import com.google.protobuf.InvalidProtocolBufferException;

/**
 * Created by zhangminghua on 2016/5/26.
 */
public class TestProtoBuf {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        AddressBookProtos.Person.Builder builder = AddressBookProtos.Person.newBuilder();
        builder.setId(100);
        builder.setEmail("12423423@qq.com");
        builder.setName("lewis");

       // AddressBookProtos.AddressBook
        AddressBookProtos.Person.PhoneType phoneType = AddressBookProtos.Person.PhoneType.WORK;
        AddressBookProtos.Person.PhoneNumber.Builder phoneNumberBuilder = AddressBookProtos.Person.PhoneNumber.newBuilder();
        phoneNumberBuilder.setType(phoneType);
        phoneNumberBuilder.setNumber("1383838438");
        AddressBookProtos.Person.PhoneNumber phoneNumber = phoneNumberBuilder.build();
        System.out.println(phoneNumber.toString());
        //builder.setPhone(-1,phoneNumber);
        AddressBookProtos.Person person = builder.build();
        System.out.println(person.toString());
        byte[] phoneNumberBytes = phoneNumber.toByteArray();
        AddressBookProtos.Person.PhoneNumber phoneNumber1 = AddressBookProtos.Person.PhoneNumber.parseFrom(phoneNumberBytes);
        System.out.println(phoneNumber1.toString());
        System.out.println(phoneNumber == phoneNumber1);
        System.out.println(phoneNumber.toString().equals(phoneNumber1.toString()));
    }

}
