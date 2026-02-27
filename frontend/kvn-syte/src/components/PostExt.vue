<template>
    <div class="ui text container">
        <h2 class="ui header">
            {{ post.title }}
        </h2>
        <p>
            {{ post.data }}
        </p>
    </div>
    <div class="ui segment" v-for="block in post.blocks" :key="block.id">
        <div v-if="block.type == 'text'" class="ui fluid container">
            <p v-for="i in block.data.length" :key="i" align="left"> 
                {{ block.data[i-1] }}
                
            </p>
        </div>
        <div v-else-if="block.type == 'mark-list'" class="ui fluid container">
            <ul class="ui list">
                <li v-for="i in block.data.length" :key="i" align="left"> 
                    {{ block.data[i-1] }}
                </li>
            </ul>
        </div>
        <div v-else-if="block.type == 'numb-list'" class="ui fluid container">
            <ol class="ui list">
                <li v-for="i in block.data.length" :key="i" align="left"> 
                    {{ block.data[i-1] }}
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
            <img class="video"
                :src="block.data[0]"/>
        </div>
    </div>
</template>

<script setup>
import { ref, defineProps } from 'vue';

const post = ref({
    title: 'Прошёл фестиваль 2 сезона',
    data: '13.02.2026',
    blocks: [
    {
        id: 1,
        type: 'text',
        data: ['Раз-раз-раз-раз-раз', 'Два-два-два-два-два-два-два', 'Два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два']
    },
    {
        id: 2,
        type: 'mark-list',
        data: ['Раз-раз-раз-раз-раз', 'Два-два-два-два-два-два-два', 'Два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два']
    },
    {
        id: 3,
        type: 'numb-list',
        data: ['Раз-раз-раз-раз-раз', 'Два-два-два-два-два-два-два', 'Два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два']
    },
    {
        id: 4,
        type: 'video',
        data: ['https://vkvideo.ru/video_ext.php?oid=-127553155&id=456245257&hash=e92d9f33bf048f38&hd=3']
    },
    {
        id: 5,
        type: 'photo',
        data: ['https://i.pinimg.com/originals/7d/be/d9/7dbed90655c6d7de0f4d01eb01b9cbe1.jpg?nii=t']
    }
]
})

const props = defineProps({
    post: Object
})
</script>

<style>
.video{
    width: 100%;
    height: 360px;
}
</style>