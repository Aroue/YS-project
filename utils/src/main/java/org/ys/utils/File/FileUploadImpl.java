package org.ys.utils.File;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Component
public class FileUploadImpl implements FileUpload {
    /**
     * 上传单个文件
     *
     * @param file
     * @return
     */
    @Override
    public Attachment upload(MultipartFile file) {
        Attachment attachment = new Attachment();
        attachment.setName("miao.jpeg");
        attachment.setId(1);
        attachment.setPath("http://www.k1982.com/show/up/201407/2014071801564163.jpeg");
        attachment.setSize(200);
        return attachment;
    }

    /**
     * 上传多个文件
     *
     * @param files
     * @return
     */
    @Override
    public List<Attachment> upload(List<MultipartFile> files) {
        Attachment attachment = new Attachment();
        attachment.setName("miao.jpeg");
        attachment.setId(1);
        attachment.setPath("http://www.k1982.com/show/up/201407/2014071801564163.jpeg");
        attachment.setSize(200);
        List<Attachment> list = new ArrayList<>();
        list.add(attachment);
        return list;
    }
}
