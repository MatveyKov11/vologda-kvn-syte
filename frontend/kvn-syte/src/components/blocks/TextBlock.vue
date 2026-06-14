<template>
    <div class="ui fluid container">
        <p v-for="(el, i) in props.text" :key="i" align="left">
            {{ el }}
            <i class="x icon" @click="$emit('delete', i)"/>
            <i class="arrow up icon" @click="$emit('up', i)"/>
                    <i class="arrow down icon" @click="$emit('down', i)"/>
        </p>
        <div class="ui action fluid input">
            <input type="text" placeholder="Введите абзац..." v-model="inputText" @keypress.enter="$emit('add', inputText); inputText = ''"/>
            <button class="ui blue icon button" @click="$emit('add', inputText); inputText = ''">
                <i class="plus icon"/>
            </button>
        </div>
    </div>
    {{ props.colonsNumber }}
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
    }
})

const inputText = ref("")
</script>