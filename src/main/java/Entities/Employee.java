/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author carlos.martinez
 */
public class Employee {

    Optional<Address> address;

    public Employee(Optional<Address> address) {
        this.address = address;
    }

    public Optional<Address> getAdress() {
        return address;
    }
}
