package com.psl.util;

import java.util.List;
import java.util.Set;

import com.psl.beans.Student;
import com.psl.exceptions.InsufficientDataException;

public interface DataManager {
  Set <Student> populateData(String fileName, String adressfile);
  Set <Student> sortData(Set<Student> set );
  void validateData(Set<Student> set) throws InsufficientDataException;
  
}
