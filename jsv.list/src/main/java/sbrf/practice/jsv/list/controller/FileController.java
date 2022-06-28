package sbrf.practice.jsv.list.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sbrf.practice.jsv.list.dto.files.CreateFileDto;
import sbrf.practice.jsv.list.dto.files.FileDto;
import sbrf.practice.jsv.list.dto.files.UpdateFileDto;
import sbrf.practice.jsv.list.service.FileService;

import org.springframework.core.io.Resource;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping()
@RequiredArgsConstructor
@Log4j2
public class FileController {

    private final FileService service;

    @GetMapping("files")
    private List<FileDto> findAllFiles() {
        log.info("Trying to get all existing files");
        return service.findAllFiles();
    }

    @GetMapping("files/{id}")
    private FileDto findFileById(@PathVariable("id") UUID id) {
        log.info("Trying to get a file by given id={}", id);
        return service.findFileById(id);

    }

    @GetMapping("users/{userId}/files")
    private List<FileDto> findFilesByAuthor(@PathVariable("id") UUID authorId) {
       log.info("Trying to get all files the user with given id owns");
       return service.findFilesByAuthor(authorId);
    
    }

    @GetMapping("files/sorted")
    private Page<FileDto> findAllSorted(@RequestParam("sort") Sort sort,
                                     @RequestParam("page") Integer page,
                                     @RequestParam("val") Integer valPerPage) {
        log.info("Trying to get and sort all existing files by", sort);
        return service.findAllSorted(sort, page, valPerPage);
    }


    @PostMapping("files")
    public FileDto create(@Valid @ModelAttribute CreateFileDto dto) throws IOException {
        log.info("Trying to upload new file");
        return service.create(dto);

    }

    @PutMapping("files/{id}")
    public FileDto update(@PathVariable("id") UUID id, @Valid @ModelAttribute UpdateFileDto dto) throws IOException {
        log.info("Trying to update a file with given id={}", id);
        return this.service.update(id, dto);

    }

    @GetMapping(path = "files/{id}/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@PathVariable("id") UUID id) throws IOException {
        log.info("Trying to download a file with given id={}", id);
        return this.service.download(id);
        
    }

    @DeleteMapping("files/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        log.info("Trying to delete a file with given id={}", id);
        service.deleteById(id);
    }
}
