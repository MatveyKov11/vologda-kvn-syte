<template>
    <div class="ui fluid container" :style="{columnCount: props.colonsNumber}">
        <p v-for="(el, i) in props.text" :key="i" align="left">
            {{ el }}
            <i class="x icon" @click="$emit('delete', i)" v-if="props.isEdit"/>
            <i class="arrow up icon" @click="$emit('up', i)" v-if="props.isEdit"/>
                    <i class="arrow down icon" @click="$emit('down', i)" v-if="props.isEdit"/>
        </p>
    </div>
    <div class="ui hidden divider" v-if="props.isEdit"/>
    <div class="ui action fluid input" v-if="props.isEdit">
        <input type="text" placeholder="Введите абзац..." v-model="inputText" 
            @keypress.enter="$emit('add', inputText); inputText = ''"/>
        <button class="ui blue icon button" @click="$emit('add', inputText); inputText = ''">
            <i class="plus icon"/>
        </button>
    </div>
</template>

<script setup>
import { ref } from 'vue';

const props = defineProps({
    text: {
        type: Array,
        required: true
    },
    colonsNumber: {
        type: Number,
        required: true
    },
    isEdit: {
        type: Boolean,
        required: true
    }
})
const inputText = ref("")
</script>