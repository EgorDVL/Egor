package service;

import bean.Journal;

import java.util.List;

/**
 * Created by Egor on 24.01.2017.
 */
public interface JournalService {

    int createJournal(Journal journal);

    List<Journal> getJournalPatient(int patientId);

    boolean deleteJournalBtPatientId(int patientId);
}
