<template>
    <div class="back">
        <div class="window">
            <div class="ui buttons" style="position: absolute; top: 5px; right: 5px; z-index: 997;">
                <div class="ui icon button" @click="$emit('quit')">
                    <i class="x icon"></i>
                </div>
            </div>
            <div class="ui text container segment" style="width: 100%">
                <h2 class="ui header">
                     Пост {{ post.title }}!!! {{ props.postId }}
                </h2>
                <p>
                    {{ post.data }}
                </p>
                <div class="ui segment" v-for="(block, i) in post.blocks" :key="i">
                    <div v-if="block.type == 'text'" class="ui fluid container">
                        <p v-for="(el, ind) in block.data" :key="ind" align="left"> 
                            {{ el }}
                        </p>
                    </div>
                    <div v-else-if="block.type == 'mark-list'" class="ui fluid container">
                        <ul class="ui list">
                            <li v-for="(el, ind) in block.data" :key="ind" align="left"> 
                                {{ el }}
                            </li>
                        </ul>
                    </div>
                    <div v-else-if="block.type == 'numb-list'" class="ui fluid container">
                        <ol class="ui list">
                            <li v-for="(el, ind) in block.data" :key="ind" align="left"> 
                                {{ el }}
                            </li>
                        </ol>
                    </div>
                    <div v-else-if="block.type == 'video'" class="ui fluid container">
                        <iframe class="video"
                            :src="block.data[0]" 
                            allow="autoplay; encrypted-media; fullscreen; picture-in-picture; screen-wake-lock;" 
                            frameborder="0" allowfullscreen>
                        </iframe>
                    </div>
                    <div v-else-if="block.type == 'photo'" class="ui fluid container">
                        <img class="video" :src="block.data[0]"/>
                        <div class='gallery'>
                            <img v-for="(el, ind) in block.data" :key="ind" style="margin-right: 1%; margin-left: 1%;"
                                :width="lenItem(block.data.length)" :src="el"/>
                        </div>
                    </div>
                </div>
                <div class="ui clearing divider"></div>
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
        "Желаем сил, характера, надёжной команды рядом и побед — на сцене и за её пределами. Спасибо, что делаете КВН ярче, смелее и смешнее! С праздником!"]},
        {type:"photo", data:["https://sun9-24.userapi.com/s/v1/ig2/f8H3AIGcdX1uvs0VmSYqevznAjgrXZx5Y9D9zJmmoyPLkLMXMqgb9MMcZaB3cmIr-wtlkL4wxQXlBX1-LgtXWodA.jpg?quality=95&as=32x21,48x32,72x48,108x72,160x107,240x160,360x240,480x320,540x360,640x427,720x480,1080x720,1280x853,1440x960,2560x1707&from=bu&cs=2560x0",
        "https://sun9-41.userapi.com/s/v1/ig2/LJrwnkXF_fQvJ80DCTtHX3fERt209-5Y4NJ2a-vULG_Q_oq4cE1bdujFyaisVOWDiQhSiaCjuAeLSDy1IJ2PRBhh.jpg?quality=95&as=32x21,48x32,72x48,108x72,160x107,240x160,360x240,480x320,540x360,640x427,720x480,1080x720,1280x853,1440x960,2560x1707&from=bu&cs=2560x0",
        "https://sun9-23.userapi.com/s/v1/ig2/XmOXw_--LS5EOVGoG-i00REt_Xrrd3Zj3qY85VHp-AZD7Xr2PNo9ZEoUfVspRWuh_V2JgIlbBaAQXtMz0UzvFUAk.jpg?quality=95&as=32x21,48x32,72x48,108x72,160x107,240x160,360x240,480x320,540x360,640x427,720x480,1080x720,1280x853,1440x960,2560x1707&from=bu&cs=2560x0",
        "https://sun9-80.userapi.com/s/v1/ig2/cxa7eMMZPtfQt80MCjO6mLhauUnNKNsI7ip-BFzK-hXDx4fY1y8EDcenG28r3HaGGX36oZMda6xU7uPrQxPCwOnz.jpg?quality=95&as=32x21,48x32,72x48,108x72,160x107,240x160,360x240,480x320,540x360,640x427,720x480,1080x720,1280x853,1440x960,2560x1707&from=bu&cs=2560x0"]}
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
  background-color: #ffffff;
  border: 3px solid #000000;
  padding: 15px 15px;
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