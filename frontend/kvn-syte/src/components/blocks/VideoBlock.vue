<template>
    <div class="ui hidden divider" v-if="!props.isEdit"/>
    <div class="ui fluid container">
        <iframe class="video"
            :src="props.videoSrc" 
            allow="autoplay; encrypted-media; fullscreen; picture-in-picture; screen-wake-lock;" 
            frameborder="0" allowfullscreen>
        </iframe>
    </div>
    <div class="ui hidden divider" v-if="props.isEdit"/>
    <div class="ui action fluid input" v-if="props.isEdit">
        <input type="text" placeholder="Введите код для вставки видео..." v-model="inputText" 
            @keypress.enter="$emit('edit', inputText); inputText = ''"/>
        <button class="ui blue icon button" @click="$emit('edit', inputText); inputText = ''">
            <i class="edit icon"/>
        </button>
    </div>
    <div class="ui hidden divider" v-else/>
</template>

<script setup>
import { ref } from 'vue';

const props = defineProps({
    videoSrc: {
        type: String,
        required: true
    },
    isEdit: {
        type: Boolean,
        required: true
    }
})
const inputText = ref("")
</script>

<style scoped>
.video{
    width: 100%;
}
</style>