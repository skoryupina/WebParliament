package com.skoryupina.bootstrap;

import com.skoryupina.entities.*;
import com.skoryupina.repositories.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private DistrictRepository districtRepository;
    private DeputyRepository deputyRepository;
    private PartyRepository partyRepository;
    private FractionRepository fractionRepository;
    private MeetingRepository meetingRepository;

    private Logger log = Logger.getLogger(DataLoader.class);

    @Autowired
    public void setDistrictRepository(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    @Autowired
    public void setDeputyRepository(DeputyRepository deputyRepository) {
        this.deputyRepository = deputyRepository;
    }

    @Autowired
    public void setPartyRepository(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    @Autowired
    public void setFractionRepository(FractionRepository fractionRepository) {
        this.fractionRepository = fractionRepository;
    }

    @Autowired
    public void setMeetingRepository(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //создание округов
        ArrayList<District> districts = createDistricts();

        //создание депутатов
        ArrayList<Deputy> deputies = createDeputies(districts);

        //создание партий
        ArrayList<Party> parties = createParties(deputies);
    }

    private ArrayList<District> createDistricts() {
        String[] districtNames = new String[]{
                "Красноглинский",
                "Самарский",
                "Советский",
                "Черноземский",
                "Промышленный",
                "Безымянный"
        };

        ArrayList<District> districts = new ArrayList<>();
        for (String districtName : districtNames) {
            District district = new District();
            district.setName(districtName);
            districts.add(district);
        }
        districtRepository.save(districts);
        return districts;
    }

    private byte[] createImage(){
        File file = new File(getClass().getResource("/static/images/noimage.jpg").getFile());
        byte[] bFile = new byte[(int) file.length()];
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            fileInputStream.read(bFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bFile;
    }

    private ArrayList<Deputy> createDeputies( ArrayList<District> districts) {
        String[] names = new String[]{
                "Иван", "Петр", "Алексей", "Семен", "Георгий", "Денис", "Степан", "Тимофей", "Леонтий", "Роман", "Дмитрий", "Павел"
        };
        String[] surnames = new String[]{
                "Иванов", "Петров", "Алексеев", "Семенов", "Георгиев", "Денисов", "Степанов", "Тимофеев", "Леонтьев", "Романов", "Дмитриев", "Павлов"
        };

        byte[] bFile = createImage();

        ArrayList<Deputy> deputies = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < names.length; i++) {
            Deputy deputy = new Deputy();
            deputy.setName(names[i]);
            deputy.setSurname(surnames[i]);
            deputy.setJob(JobType.ORDINARY);
            deputy.setImage(bFile);

            int index = random.nextInt(districts.size()-1);
            deputy.setDistrict(districts.get(index));

            deputies.add(deputy);
        }

        districtRepository.save(districts);
        deputyRepository.save(deputies);


        return deputies;
    }

    private ArrayList<Party> createParties(ArrayList<Deputy> deputies) {
        String[] names = new String[]{
                "Красная", "Синяя", "Белая", "Русая"
        };
        int[] phoneNumbers = new int[]{
                111, 222, 333, 444
        };

        ArrayList<Address> addresses = createAddresses();
        ArrayList<Party> parties = new ArrayList<>();
        for (int partyIndex = 0, deputyIndex = 0; partyIndex < names.length; partyIndex++, deputyIndex = deputyIndex+3) {
            Party party = new Party();
            party.setName(names[partyIndex]);
            party.setAddress(addresses.get(partyIndex));
            deputies.get(deputyIndex).setJob(JobType.LEADER);
            party.setLeader(deputies.get(deputyIndex));
            deputies.get(deputyIndex).setParty(party);
            party.setPhoneNumber(phoneNumbers[partyIndex]);
            Set<Deputy> partyDeputies = new HashSet<>();
            deputies.get(deputyIndex + 1).setParty(party);
            partyDeputies.add(deputies.get(deputyIndex + 1));
            deputies.get(deputyIndex + 2).setParty(party);
            partyDeputies.add(deputies.get(deputyIndex + 2));
            party.setDeputies(partyDeputies);
            parties.add(party);
        }

        partyRepository.save(parties);
        deputyRepository.save(deputies);

        return parties;
    }

    private ArrayList<Address> createAddresses() {
        ArrayList<Address> addresses = new ArrayList<>();

        Address addressRed = new Address();
        addressRed.setCity("Самара");
        addressRed.setDistrict("Жемчужный");
        addressRed.setStreet("Лиловая");
        addressRed.setHouse(1);

        Address addressBlue = new Address();
        addressBlue.setCity("Самара");
        addressBlue.setDistrict("Радужный");
        addressBlue.setStreet("Солнечная");
        addressBlue.setHouse(2);

        Address addressWhite = new Address();
        addressWhite.setCity("Самара");
        addressWhite.setDistrict("Артистичный");
        addressWhite.setStreet("Тверская");
        addressWhite.setHouse(3);

        Address addressBlond = new Address();
        addressBlond.setCity("Самара");
        addressBlond.setDistrict("Изумрудный");
        addressBlond.setStreet("Гаечная");
        addressBlond.setHouse(3);

        addresses.add(addressRed);
        addresses.add(addressBlue);
        addresses.add(addressWhite);
        addresses.add(addressBlond);

        return addresses;
    }
}
