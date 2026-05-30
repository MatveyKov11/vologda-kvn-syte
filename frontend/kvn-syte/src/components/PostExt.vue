<template>
    <div class="ui text container">
        <h2 class="ui header">
            {{ props.post.title }}
        </h2>
        <p>
            {{ props.post.data }}
        </p>
    </div>
    <div class="ui segment" v-for="block in props.post.blocks" :key="block.id">
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
            <img :src="block.data[0]" @click="imageSrc = block.data[0]" style="width: 100%;"/>
            <div class='gallery' v-if="block.data.length > 1">
                <img v-for="i in block.data.length" :key="i" style="margin-right: 1%; margin-left: 1%;"
                    :width="lenItem(block.data.length)" :src="block.data[i-1]" @click="imageSrc = block.data[i-1]"/>
            </div>
        </div>
    </div>
    <div class="ui text container">
        <h2 class="ui header">
            Комментарии
        </h2>
    </div>
    <div class="ui segment" v-for="comment in comments" :key="comment.id" align="left">
        {{ comment.text }}
    </div>
    <div class="ui action fluid input">
        <input type="text" placeholder="Оставьте комментарий..." v-model="inputText" @keypress.enter="addComment"/>
        <button class="ui blue icon button" @click="addComment">
            <i class="edit icon"></i>
        </button>
    </div>
    <ImageWindow :image-src="imageSrc" v-if="imageSrc.length" @quit="imageSrc = ''"/>
</template>

<script setup>
import { ref } from 'vue';
import ImageWindow from './windows/ImageWindow.vue';

const props = defineProps({
    post: Object
})

const comments = ref([
])
const inputText = ref('')
const imageSrc = ref('')

function addComment(){
    comments.value.push({
        id: comments.value.length,
        text: inputText.value
    })
    inputText.value = ''
}

function lenItem(i){
    return (100 / i) - 2 + '%'
}
</script>

<style>
.video{
    width: 100%;
}
</style>