package org.ys.utils.File;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileUpload {
    /**
     * 上传单个文件
     *
     * @param file
     * @return
     */
    public Attachment upload(MultipartFile file);

    /**
     * 上传多个文件
     *
     * @param files
     * @return
     */
    public List<Attachment> upload(List<MultipartFile> files);
}
