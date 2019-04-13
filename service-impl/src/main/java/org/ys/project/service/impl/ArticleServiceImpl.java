package org.ys.project.service.impl;

import org.ys.project.dao.mapper.ArticleMapper;
import org.ys.project.entity.Article;
import org.ys.project.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Transactional
public class ArticleServiceImpl implements ArticleService {
    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleServiceImpl(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }


    @Override
    public List<Article> getAllArticle() {
        return articleMapper.selectAll();
    }

    @Override
    public Article getArticle(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean addArticle(Article article) {
        return articleMapper.insert(article) > 0;
    }

    @Override
    public Boolean updateArticle(Article article) {
        return articleMapper.updateByPrimaryKey(article) > 0;
    }

    @Override
    public Boolean deleteArticle(Integer id) {
        return articleMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public Boolean deleteArticleByUserId(Integer id) {
        return articleMapper.deleteArticleByUserId(id) > 0;
    }

    @Override
    public List<Article> selectArticleByTypeId(Integer id) {
        return articleMapper.selectArticleByTypeId(id);
    }

    @Override
    public List<Article> selectArticleByUserId(Integer id) {
        return articleMapper.selectArticleByUserId(id);
    }

    @Override
    public String delHTMLTag(String html) {
        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
        String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
        String regEx_space = "\\s*|\t|\r|\n";// 定义空格回车换行符
        String regEx_w = "<w[^>]*?>[\\s\\S]*?<\\/w[^>]*?>";//定义所有w标签


        Pattern p_w = Pattern.compile(regEx_w, Pattern.CASE_INSENSITIVE);
        Matcher m_w = p_w.matcher(html);
        html = m_w.replaceAll(""); // 过滤script标签


        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(html);
        html = m_script.replaceAll(""); // 过滤script标签


        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(html);
        html = m_style.replaceAll(""); // 过滤style标签


        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(html);
        html = m_html.replaceAll(""); // 过滤html标签


        Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);
        Matcher m_space = p_space.matcher(html);
        html = m_space.replaceAll(""); // 过滤空格回车标签


        html = html.replaceAll(" ", ""); //过滤
        return html.length() > 200 ? html.substring(0, 200) : html;// 返回文本字符串 前两百个字符
    }
}
