<template>
    <div class="ui text container">
        <h3 class="ui header">
            {{ props.post.title }}
        </h3>
        <p>
            {{ props.post.data }}
        </p>
        <div v-if="img_src != ''" class="ui fluid container">
            <img class="video"
                :src="img_src"/>
        </div>
        <p v-else>
            {{ text }}
        </p>
        <button class="ui button" @click="select">
            Подробнее...
        </button>
        <div class="ui divider"></div>
    </div>
</template>

<script setup>
import { computed, defineProps } from 'vue';

const props = defineProps({
    post: Object
})

const img_src = computed(() => {
    let i = -1
    for(let j = 0; j < props.post.blocks.length; j++){
        if (props.post.blocks[j].type == 'photo'){
            i = j
            j = props.post.blocks.length
        }
    }
    if (i == -1){
        return ''
    }
    return props.post.blocks[i].data[0]
})

const text = computed(() => {
    let i = -1
    for(let j = 0; j < props.post.blocks.length; j++){
        if (props.post.blocks[j].type == 'text'){
            i = j
            j = props.post.blocks.length
        }
    }
    if (i == -1){
        return ''
    }
    return props.post.blocks[i].data[0]
})

const emit = defineEmits(['select']);

function select(){
    emit('select')
}
</script>

<style>
.video{
    width: 100%;
    height: auto;
}
</style>