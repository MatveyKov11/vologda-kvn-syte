package com.kvn_syte.server.entities;

import java.util.ArrayList;
import java.util.Date;

import com.kvn_syte.server.entities.Block.BlockType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    Long id;

    String title;
    Date createdTime;
    ArrayList<Block> blocks;
    ArrayList<Comment> comments;
    boolean isClosedComments;
    Long likesCount;

    public ArrayList<Post> testData(){
        ArrayList<Post> a = new ArrayList<>();

        ArrayList<Block> b1;
        ArrayList<Block> b2;
        ArrayList<Block> b3;

        ArrayList<Content> c1;
        ArrayList<Content> c2;
        ArrayList<Content> c3;
        ArrayList<Content> c4;
        ArrayList<Content> c5;

        b1 = new ArrayList<>();
        c1 = new ArrayList<>();
        c1.add(new Content(0L, 0L, 1L, "Твой выход, рабочая молодежь!"));
        c1.add(new Content(0L, 0L, 2L, "17 октября мы зажигаем сцену на Кубке работающей молодежи!"));
        c1.add(new Content(0L, 0L, 3L, "Здесь встретятся не просто коллеги, а настоящие профессионалы из разных сфер: медицина, промышленность, IT, образование, сфера услуг - покажем, кто на что горазд вне офисов и цехов!"));
        c1.add(new Content(0L, 0L, 4L, "Если ваш трудовой коллектив устал прятать таланты за рабочими столами и готов блеснуть - ловите момент!"));
        c2 = new ArrayList<>();
        c2.add(new Content(0L, 0L, 1L, "Когда: 17 октября"));
        c2.add(new Content(0L, 0L, 2L, "Где: КЗ Русский Дом"));
        c2.add(new Content(0L, 0L, 3L, "Кто участвует: Команды предприятий и организаций города"));
        c3 = new ArrayList<>();
        c3.add(new Content(0L, 0L, 1L, "Прием заявок уже ОТКРЫТ! Регистрируйте свою команду для участия по ссылке: forms.yandex.ru/u/6a1d9f89..."));
        c3.add(new Content(0L, 0L, 2L, "Ждем всех! Новички и те, кто еще не пробовал себя на сцене, не бойтесь - дерзайте! Подготовить выступления помогут наши редакторы"));
        c4 = new ArrayList<>();
        c4.add(new Content(0L, 0L, 1L, "https://sun9-46.userapi.com/s/v1/ig2/__FsktIZEUtw00YNSe7cg_MHkVz81ox21uLYPwaNckGuTK6Z_ctL8PN3Dbra1gNggcEeivA_RPAISJPvoLA01RsO.jpg?quality=95&crop=0,0,1920,1920&as=32x32,48x48,72x72,108x108,160x160,240x240,360x360,480x480,540x540,640x640,720x720,1080x1080,1280x1280,1440x1440,1920x1920&from=bu&u=7Jj-5mo3Rp8Y1syAwPH8DAybAlQtr1RKKFIOo0Jutn0&cs=1920x0"));
        b1.add(new Block(0L, 0L, 1L, c1, BlockType.Text, "1"));
        b1.add(new Block(0L, 0L, 2L, c2, BlockType.List, "square"));
        b1.add(new Block(0L, 0L, 3L, c3, BlockType.Text, "1"));
        b1.add(new Block(0L, 0L, 4L, c4, BlockType.Image, "gallery"));
        a.add(new Post(0L, "Кубок работающей молодежи", new Date(), b1, new ArrayList<>(), false, 10L));

        b2 = new ArrayList<>();
        c1 = new ArrayList<>();
        c1.add(new Content(0L, 0L, 1L, "Сегодня свой День Рождения празднует Денисова Марина Васильевна! 🎉\n" + //
                        "От всей команды КВН поздравляем Вас с праздником!"));
        c1.add(new Content(0L, 0L, 2L, "Желаем крепкого здоровья, счастья, вдохновения, ярких эмоций и как можно больше поводов для улыбок и хорошего настроения"));
        c1.add(new Content(0L, 0L, 3L, "Спасибо Вам за поддержку, объективность, чувство юмора и тёплое отношение к нашим командам. Пусть каждый день приносит радость, новые достижения и только позитивные впечатления!"));
        c1.add(new Content(0L, 0L, 4L, "С Днём рождения!"));
        c2 = new ArrayList<>();
        c2.add(new Content(0L, 0L, 1L, "https://sun9-30.userapi.com/s/v1/ig2/nAYt82zuQfTlXwOkfztFhb_bqKotLRaFWFOho_6Luaxl0nlT8-OZs_J80BX0UruFYqSIDc0u8Psi-bDEZt_EKjO2.jpg?quality=95&as=32x21,48x32,72x48,108x72,160x107,240x160,360x240,480x320,540x360,640x427,720x480,1080x720,1280x853,1440x960,2560x1707&from=bu&u=4tUlK3pahLjoBquKYwvQAPKaDcIy0G5XJkzpn6qMOWU&cs=2560x0"));
        b1.add(new Block(0L, 0L, 1L, c1, BlockType.Text, "1"));
        b1.add(new Block(0L, 0L, 2L, c2, BlockType.Image, "gallery"));
        a.add(new Post(0L, "День рождения", new Date(), b2, new ArrayList<>(), false, 120L));

        b3 = new ArrayList<>();
        c1 = new ArrayList<>();
        c1.add(new Content(0L, 0L, 1L, "Студенческая Лига КВН ВоГУ запустила розыгрыш перед финалом!"));
        c1.add(new Content(0L, 0L, 2L, "Можно выиграть денежный приз, мерч, афишу с автографами и другие подарки"));
        c1.add(new Content(0L, 0L, 3L, "Условия простые: поставить лайк, написать комментарий под постом (vk.ru/wall-106233274_5127) и прийти на игру"));
        c1.add(new Content(0L, 0L, 4L, "Так что заходите в группу СтудЛиги, участвуйте в розыгрыше и обязательно приходите поддержать команды на финале"));
        c1.add(new Content(0L, 0L, 5L, "Дата, место и время:"));

        c2 = new ArrayList<>();
        c2.add(new Content(0L, 0L, 1L, "22 мая, 18:30"));
        c2.add(new Content(0L, 0L, 2L, "Актовый зал ВоГУ, пр. Победы, 37"));
        c3 = new ArrayList<>();
        c3.add(new Content(0L, 0L, 1L, "Как забронировать билеты:"));
        c4 = new ArrayList<>();
        c4.add(new Content(0L, 0L, 1L, "Переходите по ссылке и выбирайте понравившиеся места: vk.cc/cUWuG9"));
        c4.add(new Content(0L, 0L, 2L, "Выбранные места напишите в личные сообщения Ирине Завьяловой"));
        c4.add(new Content(0L, 0L, 3L, "Все готово!"));
        c5 = new ArrayList<>();
        c5.add(new Content(0L, 0L, 1L, "https://sun9-1.userapi.com/s/v1/ig2/cERXFgN7JNoEcgSv8t74w88sOVevupa_GEHSL1bgnlpyEYuoSuIrdorUQWf8oBIYoz8Le8MN7LlM3Z_zX4-JrDV4.jpg?quality=95&as=32x21,48x32,72x48,108x72,160x107,240x160,360x240,480x320,540x360,640x427,720x480,1080x720,1280x853,1440x960,1800x1200&from=bu&u=-StTCJRMBOJoKwhCidcI79gGfREHBD9qe38OWHyya4E&cs=1800x0"));
        c5.add(new Content(0L, 0L, 2L, "https://sun9-82.userapi.com/s/v1/ig2/ZMFDg9vbggSiOjTzedytlq0jqwfpENeZbsSKvF_nmnsb8JbbwOQRs2n9D0-dAHF6uKYQCxnhwKDaVlBYWlz6O9-K.jpg?quality=95&as=32x23,48x34,72x51,108x76,160x113,240x170,360x255,480x339,540x382,640x452,720x509,1080x764,1280x905,1440x1018,2000x1414&from=bu&cs=2000x0"));
        b3.add(new Block(0L, 0L, 1L, c1, BlockType.Text, "1"));
        b3.add(new Block(0L, 0L, 2L, c2, BlockType.List, "square"));
        b3.add(new Block(0L, 0L, 3L, c3, BlockType.Text, "1"));
        b3.add(new Block(0L, 0L, 4L, c4, BlockType.List, "numb"));
        b3.add(new Block(0L, 0L, 5L, c5, BlockType.Image, "carousel"));
        a.add(new Post(0L, "Финал студлиги КВН", new Date(), b3, new ArrayList<>(), false, 10L));

        return a;
    }
}
