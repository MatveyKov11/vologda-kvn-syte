<template>
    <div class="ui left floated icon buttons">
        <div class="ui icon button" @click="home">
            <i class="home icon"></i>
        </div>
        <div class="ui icon button" @click="edit">
            <i class="edit icon"></i>
        </div>
        <div class="ui icon button" @click="admin">
            <i class="table icon"></i>
        </div>
    </div>
    <div v-if="selected == -1" class="ui text container">
        <h2 class="ui header">
            <div class="content">
                Главная страница сайта
            </div>
        </h2>
        <div v-for="post in posts" :key="post.id">
            <PostCrop :post="post" @select="selected = post.id"/>
        </div>
    </div>
    <div v-else class="ui text container">
        <PostExt :post="posts[selected]"/>
    </div>
</template>

<script setup>
import router from '@/router';
import PostExt from './PostExt.vue';
import { ref } from 'vue';
import PostCrop from './PostCrop.vue';

function home() {
    selected.value = -1
    router.push({name: 'Home'})
}

function edit() {
    router.push({name: 'Editor Home'})
}

function admin() {
    router.push({name: 'Admin Home'})
}

router.push({name: 'Home'})

const selected = ref(-1)

const posts = ref([
    {
        id: 0,
        title: 'День рождения',
        data: '23.02.2026',
        blocks: [
            {id:0, type:"text", data :["Сегодня День рождения Губернатора Вологодской области Георгия Юрьевича Филимонова!","Желаем Вам неиссекаемого потока энергии, крепкого здоровья, достижения всех поставленных целей, больших планов и новых возможностей!","Спасибо, что всегда готовы поддержать инициативы творческой молодежи Вологодчины!"]},
            {id:1, type:"photo", data:["https://sun9-9.userapi.com/s/v1/ig2/QJ0OtoLWPRoVZxUm51HoEvp1tigBY_j-R3SWaDLPB9MMpgDoFVOre7xNVgWh1-u76hkvuHAp29zr_6ExTjxYyVqg.jpg?quality=95&as=32x21,48x32,72x48,108x72,160x107,240x160,360x240,480x320,540x360,640x426,720x480,1080x720,1280x853&from=bu&cs=1280x0"]},
        ]
    },
    {
        id: 1,
        title: 'С 23 февраля!',
        data: '23.02.2026',
        blocks: [
            {id:0, type:"text", data :["Дорогие мужчины КВН — участники, редакторы, ведущие, руководители команд и наши зрители! Поздравляем вас с 23 февраля!",
            "Желаем сил, характера, надёжной команды рядом и побед — на сцене и за её пределами. Спасибо, что делаете КВН ярче, смелее и смешнее! С праздником!"]},
            {id:1, type:"photo", data:["https://sun9-24.userapi.com/s/v1/ig2/f8H3AIGcdX1uvs0VmSYqevznAjgrXZx5Y9D9zJmmoyPLkLMXMqgb9MMcZaB3cmIr-wtlkL4wxQXlBX1-LgtXWodA.jpg?quality=95&as=32x21,48x32,72x48,108x72,160x107,240x160,360x240,480x320,540x360,640x427,720x480,1080x720,1280x853,1440x960,2560x1707&from=bu&cs=2560x0",
            "https://sun9-41.userapi.com/s/v1/ig2/LJrwnkXF_fQvJ80DCTtHX3fERt209-5Y4NJ2a-vULG_Q_oq4cE1bdujFyaisVOWDiQhSiaCjuAeLSDy1IJ2PRBhh.jpg?quality=95&as=32x21,48x32,72x48,108x72,160x107,240x160,360x240,480x320,540x360,640x427,720x480,1080x720,1280x853,1440x960,2560x1707&from=bu&cs=2560x0",
            "https://sun9-23.userapi.com/s/v1/ig2/XmOXw_--LS5EOVGoG-i00REt_Xrrd3Zj3qY85VHp-AZD7Xr2PNo9ZEoUfVspRWuh_V2JgIlbBaAQXtMz0UzvFUAk.jpg?quality=95&as=32x21,48x32,72x48,108x72,160x107,240x160,360x240,480x320,540x360,640x427,720x480,1080x720,1280x853,1440x960,2560x1707&from=bu&cs=2560x0",
            "https://sun9-80.userapi.com/s/v1/ig2/cxa7eMMZPtfQt80MCjO6mLhauUnNKNsI7ip-BFzK-hXDx4fY1y8EDcenG28r3HaGGX36oZMda6xU7uPrQxPCwOnz.jpg?quality=95&as=32x21,48x32,72x48,108x72,160x107,240x160,360x240,480x320,540x360,640x427,720x480,1080x720,1280x853,1440x960,2560x1707&from=bu&cs=2560x0"]}
        ]
    },
    {
        id: 2,
        title: 'Работа с редакторами',
        data: '18.02.2026',
        blocks: [
            {id:0, type:"text", data :["Работа с редакторами — один из ключевых этапов развития команд КВН","Именно поэтому для участников был проведён мастер-класс, в рамках которого команды получили обратную связь по своим выступлениям, разбор материала и рекомендации по дальнейшей работе в сезоне.",
            "Такая работа помогает командам точнее понимать требования, видеть точки роста и улучшать свои номера!"]},
            {id:1, type:"photo", data:["https://sun9-35.userapi.com/s/v1/ig2/s22wrplkkeCt0g5go2z3rMPQdTfQs1cle8wuCyiSAv3rrEbO-PldJn7xu-btJCtzS0FIMIhKLI50_SPzKI8SiV4j.jpg?quality=95&as=32x24,48x36,72x54,108x81,160x120,240x180,360x270,480x360,540x405,640x480,720x540,1080x810,1280x960,1440x1080,2560x1920&from=bu&cs=2560x0",
            "https://sun9-13.userapi.com/s/v1/ig2/wpwy4OmO8RU_9SjgpxtBJugxvRMzqsahq395fpw2ORmXOpTdmqltGfgbLTYRBLEAMyGzkvBVjfMpbC_Q_E0EHpJn.jpg?quality=95&as=32x24,48x36,72x54,108x81,160x120,240x180,360x270,480x360,540x405,640x480,720x540,1080x810,1280x960,1440x1080,2560x1920&from=bu&cs=2560x0",
            "https://sun9-63.userapi.com/s/v1/ig2/QixjVcuICbbHm2xon37CA9ni2DLD7QVsJ4ZQljPqJNGqyZOYGZe8vzU7UQnkCxkEctZQqyMejzSEBCyDnYEx0SMN.jpg?quality=95&as=32x24,48x36,72x54,108x81,160x120,240x180,360x270,480x360,540x405,640x480,720x540,1080x810,1280x960,1440x1080,2560x1920&from=bu&cs=2560x0",
            "https://sun9-80.userapi.com/s/v1/ig2/1u1XNeCQhH8XjOYHmh-asfwNPrUSau2vfn-Tb5i39QvDHfLSFDgoCvbHjazD5JiH2qgxZGz9dY5MgZhp6QYMuoJL.jpg?quality=95&as=32x24,48x36,72x54,108x81,160x120,240x180,360x270,480x360,540x405,640x480,720x540,1080x810,1280x960,1440x1080,2560x1920&from=bu&cs=2560x0"]}
        ]
    }
])
</script>