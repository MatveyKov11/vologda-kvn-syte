<template>
    <div class="ui text container">
        <h2 class="ui header">
            <div class="content">
                Конкурсы игр
            </div>
        </h2>
    </div>
    <div class="ui hidden divider"></div>
    <div class="ui input">
        <input type="text" name="name" v-model="tableTitle" placeholder="Название таблицы">
    </div>
    <table class="ui table">
        <thead>
            <tr>
                <th class="center aligned">Название конкурса</th>
                <th class="center aligned">Описание</th>
                <th class="one wide"></th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(contest, i) in contests" :key="i" @mouseover="contest.isVisible = true" @mouseleave="contest.isVisible = false">
                <td>
                    <div class="ui fluid input">
                        <input type="text" name="name" v-model="contest.name">
                    </div>
                </td>
                <td>
                    <div class="ui fluid input">
                        <input type="text" name="description" v-model="contest.description">
                    </div>
                </td>
                <td>
                    <div class="ui icon red button" @click="deleteRow(i)" v-if="contest.isVisible">
                        <i class="x icon"/>
                    </div>
                </td>
            </tr>
        </tbody>
    </table>
    <button class="ui primary button" @click="addRow">
        <i class="plus icon"/> Добавить конкурс
    </button>
    <button class="ui green button" @click="saveChanges" v-if="props.table.contests">
        <i class="check icon"/> Сохранить изменения
    </button>
    <button class="ui green button" @click="saveTable" v-else>
        <i class="check icon"/> Сохранить таблицу
    </button>
    <button class="ui button" @click="lookTable">
        <i class="eye icon"/> Предпросмотр таблицы
    </button>
    <TableWindow :tableId="-1" :table="table" v-if="isLook" @quit="isLook = false; table = {columns: [], rows: []}"/>
</template>

<script setup>
import router from '@/router';
import { ref } from 'vue';
import TableWindow from '../windows/TableWindow.vue';

const props = defineProps({
    table: {
        type: Object,
        required: true
    }
})

const contests = ref([
    {
        name: 'Визитка',
        description: '---',
        isVisible: false  // !!!
    },
    {
        name: 'Разминка',
        description: '---',
        isVisible: false  // !!!
    },
    {
        name: 'Сложная ситуация',
        description: '---',
        isVisible: false  // !!!
    },
    {
        name: 'Музыкальное домашнее задание',
        description: '---',
        isVisible: false  // !!!
    }
])
const tableTitle = ref("")
const table = ref({
    title: "",
    columns: [],
    rows: []
})
const isLook = ref(false)

if (props.table.contests){
    contests.value = JSON.parse(JSON.stringify(props.table.contests))
    tableTitle.value = ''+props.table.title
}

function deleteRow(r){
    let contestsCopy = []
    for(let i = 0; i < contests.value.length; i++){
        if(i != r){
            contestsCopy.push(contests.value[i])
        }
    }
    contests.value = contestsCopy
}

function addRow(){
    contests.value.push({})
}

function fixTable(){
    table.value.title = tableTitle.value
    table.value.columns = ["Название конкурса", "Описание"]

    contests.value.forEach(contest => {
        table.value.rows.push([
            contest.name, contest.description
        ])
    })
}

function saveChanges(){
    fixTable()

    alert('Заглушка! Изменения сохранены!')
    router.push({name: 'Admin Home'})
}

function saveTable(){
    fixTable()

    alert('Заглушка! Таблица сохранена!')
    router.push({name: 'Admin Home'})
}

function lookTable(){
    fixTable()

    isLook.value = true
}
</script>