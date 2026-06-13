<template>
    <div class="back">
        <div class="window">
            <div class="ui buttons" style="position: absolute; top: 5px; right: 5px; z-index: 997;">
                <div class="ui icon button" @click="$emit('quit')">
                    <i class="x icon"/>
                </div>
            </div>
            <div class="ui text container segment" style="width: 100%">
                <h2 class="ui header">
                     Пост {{ post.title }}!!! {{ props.postId }}
                </h2>
                <p>
                    {{ post.data }}
                </p>
                <div v-for="(block, i) in post.blocks" :key="i" class="ui container">
                    <div v-if="block.type == 'text'" class="ui container">
                        <p v-for="(el, ind) in block.data" :key="ind" align="left"> 
                            {{ el }}
                        </p>
                    </div>
                    <div v-else-if="block.type == 'mark-list'" class="ui container">
                        <ul class="ui list">
                            <li v-for="(el, ind) in block.data" :key="ind" align="left"> 
                                {{ el }}
                            </li>
                        </ul>
                    </div>
                    <div v-else-if="block.type == 'numb-list'" class="ui container">
                        <ol class="ui list">
                            <li v-for="(el, ind) in block.data" :key="ind" align="left"> 
                                {{ el }}
                            </li>
                        </ol>
                    </div>
                    <div v-else-if="block.type == 'video'" class="ui container">
                        <iframe class="video"
                            :src="block.data[0]" 
                            allow="autoplay; encrypted-media; fullscreen; picture-in-picture; screen-wake-lock;" 
                            frameborder="0" allowfullscreen>
                        </iframe>
                    </div>
                    <div v-else-if="block.type == 'photo'" class="ui container">
                        <img class="video" :src="block.data[0]"/>
                        <div class="ui segment">
                            <img v-for="(el, ind) in block.data" :key="ind" style="margin-right: 1%; margin-left: 1%;"
                                :width="lenItem(block.data.length)" :src="el"/>
                        </div>
                    </div>
                    <div v-else-if="block.type == 'table'" class="ui container">
                        <table class="ui table">
                            <thead>
                                <tr>
                                    <th v-for="(col, i) in block.data[0]" :key="i">
                                        {{ col }}
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr v-for="(row, i) in block.data.slice(1)" :key="i">
                                    <td v-for="(el, j) in row" :key="j">
                                        <p> {{ el }}</p>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="ui clearing divider"/>
                <button class = "ui primary button" @click="$emit('edit')">Открыть в редакторе</button>
                <button class = "ui button" @click="$emit('quit')">Выйти</button>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';


const props = defineProps({
    postId: {
        required: true
    }
})

//const emit = defineEmits(['quit', 'edit', 'block', 'delete'])

// Заглушка-пост
const post = ref({
    title: 'С 23 февраля!',
    data: '23.02.2026',
    blocks: [
        {type:"text", data :["Дорогие мужчины КВН — участники, редакторы, ведущие, руководители команд и наши зрители! Поздравляем вас с 23 февраля!",
        "Желаем"]},
        {type:"mark-list", data :["сил,", "характера,", "надёжной команды рядом,", "побед — на сцене и за её пределами."]},
        {type:"text", data :["Спасибо, что делаете КВН"]},
        {type:"numb-list", data :["ярче,", "смелее", "смешнее!"]},
        {type:"text", data :["С праздником!"]},
        {type:"photo", data:["https://sun9-24.userapi.com/s/v1/ig2/f8H3AIGcdX1uvs0VmSYqevznAjgrXZx5Y9D9zJmmoyPLkLMXMqgb9MMcZaB3cmIr-wtlkL4wxQXlBX1-LgtXWodA.jpg?quality=95&as=32x21,48x32,72x48,108x72,160x107,240x160,360x240,480x320,540x360,640x427,720x480,1080x720,1280x853,1440x960,2560x1707&from=bu&cs=2560x0",
        "https://sun9-41.userapi.com/s/v1/ig2/LJrwnkXF_fQvJ80DCTtHX3fERt209-5Y4NJ2a-vULG_Q_oq4cE1bdujFyaisVOWDiQhSiaCjuAeLSDy1IJ2PRBhh.jpg?quality=95&as=32x21,48x32,72x48,108x72,160x107,240x160,360x240,480x320,540x360,640x427,720x480,1080x720,1280x853,1440x960,2560x1707&from=bu&cs=2560x0",
        "https://sun9-23.userapi.com/s/v1/ig2/XmOXw_--LS5EOVGoG-i00REt_Xrrd3Zj3qY85VHp-AZD7Xr2PNo9ZEoUfVspRWuh_V2JgIlbBaAQXtMz0UzvFUAk.jpg?quality=95&as=32x21,48x32,72x48,108x72,160x107,240x160,360x240,480x320,540x360,640x427,720x480,1080x720,1280x853,1440x960,2560x1707&from=bu&cs=2560x0",
        "https://sun9-80.userapi.com/s/v1/ig2/cxa7eMMZPtfQt80MCjO6mLhauUnNKNsI7ip-BFzK-hXDx4fY1y8EDcenG28r3HaGGX36oZMda6xU7uPrQxPCwOnz.jpg?quality=95&as=32x21,48x32,72x48,108x72,160x107,240x160,360x240,480x320,540x360,640x427,720x480,1080x720,1280x853,1440x960,2560x1707&from=bu&cs=2560x0"]},
        {type: "table", data:[["Команда", "Приветствие", "Разминка", "Домашнее задание", "Итого"], ["35 элемент", 5, 5, 5, 15], ["Теория хаоса", 5, 5, 4, 14], ["Люди ФСИНем", 5, 4, 5, 14]]}
    ]
})

function lenItem(i){
    return (100 / i) - 2 + '%'
}

</script>

<style scoped>
.window {
  position: fixed;
  z-index: 999;
  top: 15%;
  left: 25%;
  width: 50%;
  height: 70%;
  background-color: #ffffff;
  border: 3px solid #000000;
  padding: 15px 15px;
  overflow: scroll;
}

.back {
    position: fixed;
    z-index: 998;
    top: 0%;
    left: 0%;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
}
</style>