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
                     {{ post.title }}
                </h2>
                <p>
                    {{ post.date }}
                </p>
                <div class="ui container" v-for="(block, i) in post.blocks" :key="i">
                    <TextBlock :text="block.data" :colons-number="block.meta" :is-edit="false" v-if="block.type == 'text'"/>
                    <ListBlock :text="block.data" :list-type="block.meta" :is-edit="false" v-else-if="block.type == 'list'"/>
                    <VideoBlock :video-src="block.data[0]" :is-edit="false" v-else-if="block.type == 'video'"/>
                    <ImageBlock :image-src="block.data" :view-type="block.meta" :is-edit="false" v-else-if="block.type == 'image'"/>
                    <TableBlock :table-id="block.data[0]" :view-columns="block.meta" :is-edit="false" v-else-if="block.type == 'table'"/>
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
import TextBlock from '../blocks/TextBlock.vue';
import ListBlock from '../blocks/ListBlock.vue';
import VideoBlock from '../blocks/VideoBlock.vue';
import ImageBlock from '../blocks/ImageBlock.vue';
import TableBlock from '../blocks/TableBlock.vue';

const props = defineProps({
    postId: {
        type: Number,
        required: true
    },
    post: {
        type: Object,
        required: true
    }
})

//const emit = defineEmits(['quit', 'edit', 'block', 'delete'])

// Заглушка-пост
const post = ref({
    title: 'С 23 февраля!',
    date: '23.02.2026',
    blocks: [
        {
            type: "text",
            data: [
                "Дорогие мужчины КВН — участники, редакторы, ведущие, руководители команд и наши зрители! Поздравляем вас с 23 февраля!",
                "Желаем"],
            meta: 1
        },
        {
            type: "list",
            data: [
                "сил,", 
                "характера,", 
                "надёжной команды рядом,", 
                "побед — на сцене и за её пределами."],
            meta: 'disc'
        },
        {
            type: "text",
            data :["Спасибо, что делаете КВН"],
            meta: 1
        },
        {
            type: "list",
            data: [
                "ярче,",
                "смелее",
                "смешнее!"],
            meta: "numb"
        },
        {
            type: "text",
            data: ["С праздником!"],
            meta: 1
        },
        {
            type: "image",
            data: [
                "https://sun9-24.userapi.com/s/v1/ig2/f8H3AIGcdX1uvs0VmSYqevznAjgrXZx5Y9D9zJmmoyPLkLMXMqgb9MMcZaB3cmIr-wtlkL4wxQXlBX1-LgtXWodA.jpg?quality=95&as=32x21,48x32,72x48,108x72,160x107,240x160,360x240,480x320,540x360,640x427,720x480,1080x720,1280x853,1440x960,2560x1707&from=bu&cs=2560x0",
                "https://sun9-41.userapi.com/s/v1/ig2/LJrwnkXF_fQvJ80DCTtHX3fERt209-5Y4NJ2a-vULG_Q_oq4cE1bdujFyaisVOWDiQhSiaCjuAeLSDy1IJ2PRBhh.jpg?quality=95&as=32x21,48x32,72x48,108x72,160x107,240x160,360x240,480x320,540x360,640x427,720x480,1080x720,1280x853,1440x960,2560x1707&from=bu&cs=2560x0",
                "https://sun9-23.userapi.com/s/v1/ig2/XmOXw_--LS5EOVGoG-i00REt_Xrrd3Zj3qY85VHp-AZD7Xr2PNo9ZEoUfVspRWuh_V2JgIlbBaAQXtMz0UzvFUAk.jpg?quality=95&as=32x21,48x32,72x48,108x72,160x107,240x160,360x240,480x320,540x360,640x427,720x480,1080x720,1280x853,1440x960,2560x1707&from=bu&cs=2560x0",
                "https://sun9-80.userapi.com/s/v1/ig2/cxa7eMMZPtfQt80MCjO6mLhauUnNKNsI7ip-BFzK-hXDx4fY1y8EDcenG28r3HaGGX36oZMda6xU7uPrQxPCwOnz.jpg?quality=95&as=32x21,48x32,72x48,108x72,160x107,240x160,360x240,480x320,540x360,640x427,720x480,1080x720,1280x853,1440x960,2560x1707&from=bu&cs=2560x0"],
            meta: "carusel"
        }
    ]
})
if (props.postId){
    post.value.id = props.postId+0
}else if(props.post){
    post.value = JSON.parse(JSON.stringify(props.post))
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