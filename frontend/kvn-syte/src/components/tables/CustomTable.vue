<template>
    <div class="ui text container">
        <h2 class="ui header">
            <div class="content">
                Произвольная таблица
            </div>
        </h2>
    </div>
    <div class="ui hidden divider"></div>
    <div class="ui input">
        <input type="text" name="name" v-model="table.title" placeholder="Название таблицы">
    </div>
    <table class="ui table">
        <thead><tr>
            <th v-for="i in table.columns.length" :key="i">
                <div class="ui fluid input">
                    <input type="text" name="column" v-model="table.columns[i-1]" placeholder="Название столбца">
                </div>
            </th>
            <th>
                <div class="ui icon green button" @click="addColumn()">
                    <i class="plus icon"/>
                </div>
            </th>
        </tr></thead>
        <tbody>
            <tr v-for="(row, i) in table.rows" :key="i" @mouseover="row.isVisible = true" @mouseleave="row.isVisible = false">
                <td v-for="(el, j) in row.arr" :key="j">
                    <div class="ui fluid input">
                        <input type="text" :name="'row'+j" v-model="row.arr[j]">
                    </div>
                </td>
                <td>
                    <div class="ui icon red button" @click="deleteRow(i)" v-if="row.isVisible">
                        <i class="x icon"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td v-for="i in table.columns.length" :key="i" align="center">
                    <div class="ui icon fluid red button" @click="deleteColumn(i-1)">
                        <i class="x icon"/>
                        Удалить
                    </div>
                </td>
                <td/>
            </tr>
        </tbody>
    </table>
    <button class="ui primary button" @click="addRow">
        <i class="plus icon"/> Добавить строку
    </button>
    <button class="ui green button" @click="saveChanges">
        <i class="check icon"/> Сохранить изменения
    </button>
    <button class="ui button" @click="lookTable">
        <i class="eye icon"/> Предпросмотр таблицы
    </button>
    <TableWindow :tableId="-1" :table="tableCopy" v-if="isLook" @quit="isLook = false; tableCopy = {title: '', columns: [], rows: []}"/>
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

const table = ref({
    columns: ['Визитка', 'Разминка', 'Сложная ситуация'],
    rows: [
        {
            arr: [5, 5, 5],
            isVisible: false
        },
        {
            arr: [5, 4, 5],
            isVisible: false
        }
    ]
})
const tableCopy = ref({
    title: "",
    columns: [],
    rows: []
})
const isLook = ref(false)

if (props.table.rows){
    table.value = JSON.parse(JSON.stringify(props.table))
}

function deleteRow(r){
    let tableCopy = {
        columns: table.value.columns,
        rows: []
    }
    for(let i = 0; i < table.value.rows.length; i++){
        if(i != r){
            tableCopy.rows.push(table.value.rows[i])
        }
    }
    table.value = tableCopy
}

function addRow(){
    let a = []
    for(let i = 0; i < table.value.columns.length; i++){
        a.push("")
    }
    table.value.rows.push({arr: a, isVisible: false})
}

function addColumn(){
    table.value.columns.push('')
    table.value.rows.forEach(row => {
        row.arr.push("")
    })
}

function deleteColumn(c){
    let columnsCopy = []
    for(let i = 0; i < table.value.columns.length; i++){
        if(i != c){
            columnsCopy.push(table.value.columns[i])
        }
    }

    let tableCopy = {
        columns: columnsCopy,
        rows: []
    }
    for(let i = 0; i < table.value.rows.length; i++){
        tableCopy.rows.push({
            arr: [],
            isVisible: false
        })
        for(let j = 0; j < table.value.columns.length; j++){
            if(j != c){
                tableCopy.rows[i].arr.push(table.value.rows[i].arr[j])
            }
        }
    }
    table.value = tableCopy
}

function saveChanges(){
    alert('Заглушка! Изменения сохранены!')
    router.push({name: 'Admin Home'})
}

function lookTable(){
    tableCopy.value.title = table.value.title
    tableCopy.value.columns = table.value.columns

    table.value.rows.forEach((row) => {
        tableCopy.value.rows.push(row.arr)
    })

    isLook.value = true
}
</script>