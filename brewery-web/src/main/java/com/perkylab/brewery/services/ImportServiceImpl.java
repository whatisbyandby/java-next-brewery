package com.perkylab.brewery.services;
import com.perkylab.brewery.domain.Hop;
import com.perkylab.brewery.imports.HopImport;
import com.perkylab.brewery.imports.HopsImporter;
import com.perkylab.brewery.repositories.HopRepository;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ImportServiceImpl implements ImportService {

    private final HopRepository hopRepository;
    private final HopsImporter hopsImporter;

    public ImportServiceImpl(HopRepository hopRepository, HopsImporter hopsImporter){
        this.hopRepository = hopRepository;
        this.hopsImporter = hopsImporter;
    }

    @Override
    public List<Hop> importHops(String hopImport) throws IOException {
        Path path = Paths.get("./Hops.xml");
        String content = Files.readString(path, StandardCharsets.UTF_8);
        List<HopImport> importList = hopsImporter.importHops(content);

        List<Hop> hopList = importList.stream().map(this::convertImportToHop).collect(Collectors.toList());
        return StreamSupport
                .stream(hopRepository.saveAll(hopList).spliterator(), false)
                .collect(Collectors.toList());
    }

    private Hop convertImportToHop(HopImport hopImport) {
        Hop hop = new Hop();
        hop.setName(hopImport.getName());
        hop.setNotes(hopImport.getNotes());
        hop.setOrigin(hopImport.getOrigin());
        hop.setAlpha(hopImport.getAlpha());

        return hop;
    }
}
